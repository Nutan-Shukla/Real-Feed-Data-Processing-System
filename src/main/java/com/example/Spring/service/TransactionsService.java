package com.example.Spring.service;

import com.example.Spring.protos.BuyRequestDto;
import com.example.Spring.protos.SellRequestDto;
import com.example.Spring.protos.TransactionList;
import com.example.Spring.protos.UserTransactionList;

public interface TransactionsService {

     TransactionList buyMetal(BuyRequestDto buyRequestDto);

     TransactionList sellMetal(SellRequestDto sellRequestDto);

     UserTransactionList getDetailsByName();

     String getStatus(String id);

    void updateTransactionStatus(String id, String status);

    void updateQuantity(double quantity, int userId, String metal);
    void updateBalance(double balance, int userId);

    void refundMoney(int userId, double value);
    void refundQuantity(int userId, double quantity, String element);

    UserTransactionList getTransactionData();
}
