package com.example.Spring.scheduler;

import com.example.Spring.dao.UserTransactionDao;
import com.example.Spring.protos.Element;
import com.example.Spring.service.TransactionsService;
import com.example.Spring.utility.SqsTransaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@EnableScheduling
public class TransactionScheduler {

    private SqsTransaction sqsTransaction;

    private TransactionsService transactionsService;

    public TransactionScheduler(SqsTransaction sqsTransaction, TransactionsService transactionsService) {
        this.sqsTransaction = sqsTransaction;
        this.transactionsService = transactionsService;
    }
    @Scheduled(fixedRate = 5000)
    @Transactional
    public void receiveMessageFromQueue() {
        List<Element> sqsMessageList = sqsTransaction.receiveMsg();

        for (Element m : sqsMessageList) {
            String id = m.getId();
            String mode = m.getMode();
            int userId = m.getUserId();
            double newBalance = m.getBalance();
            double newQuantity = m.getMetalQuantity();
            String metal = m.getMetal();

              String status = transactionsService.getStatus(id);
              if(status.equals("Pending")) {
                  transactionsService.updateTransactionStatus( id, "Completed");
                  if (mode.equals("BUY")) {
                      transactionsService.updateQuantity(newQuantity, userId, metal);
                  } else {
                      transactionsService.updateBalance(newBalance, userId);
                  }
              }
        }

    }

}



