package com.example.Spring.service.impl;

import com.example.Spring.dao.UserTransactionDao;
import com.example.Spring.dao.UsersDao;
import com.example.Spring.exception.InsufficientBalanceException;
import com.example.Spring.exception.InsufficientQuantityException;
import com.example.Spring.protos.BuyRequestDto;
import com.example.Spring.protos.Element;
import com.example.Spring.protos.MetalPrice;
import com.example.Spring.protos.SellRequestDto;
import com.example.Spring.protos.Transaction;
import com.example.Spring.protos.TransactionList;
import com.example.Spring.protos.UserTransactionList;
import com.example.Spring.service.TransactionsService;
import com.example.Spring.utility.SqsTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionsService {

    private RestTemplate restTemplate;
    private UserTransactionDao userTransactionDao;
    private UsersDao usersDao;
    private SqsTransaction sqsTransaction;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);


    public TransactionServiceImpl(RestTemplate restTemplate, UserTransactionDao userTransactionDao, SqsTransaction sqsTransaction, UsersDao usersDao) {
        this.restTemplate = restTemplate;
        this.userTransactionDao = userTransactionDao;
        this.sqsTransaction = sqsTransaction;
        this.usersDao = usersDao;
    }

    @Override
    @Transactional
    public TransactionList buyMetal(BuyRequestDto buyRequestDto) {

        String metal = buyRequestDto.getElement();
        double quantity = buyRequestDto.getQuantity();
        List<Double> metalValues = userTransactionDao.metalValue(metal);

        if (metalValues.isEmpty()) {
            throw new RuntimeException("Metal values not found for metal: " + metal);
        }

        Double money = (Double) metalValues.get(0);
        Double metalAmount = (Double) metalValues.get(1);


        String metalval = switch (metal) {
            case "Gold" -> "XAU";
            case "Silver" -> "XAG";
            case "Palladium" -> "XPD";
            case "Platinum" -> "XPT";
            default -> null;
        };

        String url = "https://goldbroker.com/api/spot-price?metal=" + metalval + "&currency=INR" + "&weight_unit=g";
        MetalPrice metalPrice = restTemplate.getForObject(url, MetalPrice.class);

        double value = metalPrice.getValue();

        double price = value * quantity;

        Transaction.Builder trans = null;
        if (money >= price && quantity > 0) {
            double updatedBalance = money - price;
            double updatedQuantity = metalAmount + quantity;


            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            int user_id = usersDao.getUserIdFromEmail(authentication.getName());

            userTransactionDao.updateBalanceTransaction(updatedBalance, user_id);

            String id = UUID.randomUUID().toString();


            userTransactionDao.addDataInTable(id, user_id, metal, "BUY", "Pending", quantity, price, authentication.getName());

            trans = Transaction.newBuilder();
            trans.setElement(metal);
            trans.setMode("BUY");
            trans.setStatus("Pending");
            trans.setQuantity(quantity);
            trans.build();


            Element.Builder element = Element.newBuilder();
            element.setId(id);
            element.setMode("BUY");
            element.setUserId(user_id);
            element.setMetalQuantity(updatedQuantity);
            element.setBalance(updatedBalance);
            element.setPrice(price);
            element.setMetal(metal);

            try {
                sqsTransaction.sendMsg(element.build());
            } catch (Exception e) {
                LOGGER.info("{}", e.getMessage());
            }
        } else {
            throw new InsufficientBalanceException("Balance is not sufficient or quantity is negative");
        }

        return TransactionList.newBuilder().addTransaction(trans).build();
    }

    @Override
    @Transactional
    public TransactionList sellMetal(SellRequestDto sellRequestDto) {

        String metal = sellRequestDto.getElement();
        double quantity = sellRequestDto.getQuantity();

        Double money = (Double) userTransactionDao.metalValue(metal).get(0);
        Double  metalAmount = (Double) userTransactionDao.metalValue(metal).get(1);


        String metalval = switch (metal) {
            case "Gold" -> "XAU";
            case "Silver" -> "XAG";
            case "Palladium" -> "XPD";
            case "Platinum" -> "XPT";
            default -> null;
        };

        String url = "https://goldbroker.com/api/spot-price?metal=" + metalval + "&currency=INR" + "&weight_unit=g";
        MetalPrice metalPrice = restTemplate.getForObject(url, MetalPrice.class);

        double value = metalPrice.getValue();

        double price = value * quantity;
        Transaction.Builder trans = null;

        if (metalAmount > quantity &&  quantity > 0) {
            double updatedBalance = money + price;
            double updatedQuantity  = metalAmount - quantity;

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            int user_id = usersDao.getUserIdFromEmail(authentication.getName());

            userTransactionDao.updateMetalTransaction(updatedQuantity, user_id, metal);

            String id = UUID.randomUUID().toString();

            userTransactionDao.addDataInTable(id, user_id, metal, "SELL", "Pending", quantity, price, authentication.getName());

            trans = Transaction.newBuilder();
            trans.setElement(metal);
            trans.setMode("SELL");
            trans.setStatus("Pending");
            trans.setQuantity(quantity);
            trans.build();

            Element.Builder element = Element.newBuilder();
            element.setId(id);
            element.setMode("SELL");
            element.setUserId(user_id);
            element.setMetalQuantity(updatedQuantity);
            element.setBalance(updatedBalance);
            element.setMetal(metal);

            try {
                sqsTransaction.sendMsg(element.build());
            } catch (Exception e) {
                LOGGER.info("{}", e.getMessage());
            }
        } else {
            throw new InsufficientQuantityException(metal + "is not sufficient to sell or quantity is negative");
        }

        return TransactionList.newBuilder().addTransaction(trans).build();
    }

    @Override
    public UserTransactionList getDetailsByName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return userTransactionDao.getDetailsByName(usersDao.getUserIdFromEmail(authentication.getName()));


    }

    @Override
    public String getStatus(String id) {
        return userTransactionDao.getStatusFromTable(id);
    }

    @Override
    public void updateTransactionStatus(String id, String status) {
        userTransactionDao.updatedStatus(id, status);
    }

    @Override
    public void updateQuantity(double quantity, int userId, String metal) {
        userTransactionDao.updateMetalTransaction(quantity, userId, metal);
    }

    @Override
    public void updateBalance(double balance, int userId) {
        userTransactionDao.updateBalanceTransaction(balance, userId);
    }

    @Override
    public void refundMoney(int userId, double value) {
        userTransactionDao.refundTheMoney(userId, value);
    }

    @Override
    public void refundQuantity(int userId, double quantity, String element) {
        userTransactionDao.refundTheMetal(userId, quantity, element);
    }

    @Override
    public UserTransactionList getTransactionData() {
       return   userTransactionDao.getData();
    }
}
