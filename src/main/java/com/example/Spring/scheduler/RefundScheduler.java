package com.example.Spring.scheduler;

import com.example.Spring.dao.UserTransactionDao;
import com.example.Spring.protos.UserTransaction;
import com.example.Spring.protos.UserTransactionList;
import com.example.Spring.service.TransactionsService;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RefundScheduler {

    private final TransactionsService transactionsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RefundScheduler.class);


    public RefundScheduler(TransactionsService transactionsService)
    {
        this.transactionsService = transactionsService;
    }

    @Scheduled(fixedRate = 5000)
    public void refundMoney()
    {

        UserTransactionList transactionList = transactionsService.getTransactionData();

        for(UserTransaction t : transactionList.getUserTransactionList())
        {
            if(t.getStatus().equals("Pending")) {

                String mode = t.getMode();

                DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-mm-dd HH:mm:ss");

                String dateInString = t.getDate();
                DateTime dateTime = DateTime.parse(dateInString, formatter);

                DateTime newDateTime = dateTime.plusMinutes(1);


                LocalDateTime localDateTime = LocalDateTime.now();
                LocalDateTime resultDateTime = localDateTime.minusHours(5).minusMinutes(30);
                String currentTime = resultDateTime.toString();
                String frontDateTime = currentTime.substring(0,10);
                String lastDateTime = currentTime.substring(11,19);

                String finalDateTime = frontDateTime + " " + lastDateTime;

                DateTime currentdatetime = DateTime.parse(finalDateTime, formatter);



                if (newDateTime.isBefore(currentdatetime) && mode.equals("BUY")) {
                    transactionsService.updateTransactionStatus(t.getId(), "Refund");
                    transactionsService.refundMoney(t.getUserId(),t.getValue());

                } else if (newDateTime.isBefore(currentdatetime) && mode.equals("SELL")) {

                    String metal = t.getElement();

                    transactionsService.updateTransactionStatus(t.getId(), "Refund");
                    transactionsService.refundQuantity(t.getUserId(), t.getQuantity(), t.getElement());



                } else {
                   LOGGER.info("1 minutes is not completed");
                }
            }





        }
    }


}
