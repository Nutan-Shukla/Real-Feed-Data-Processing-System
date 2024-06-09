package com.example.Spring.dao;

import java.util.List;

import com.example.Spring.protos.UserTransactionList;

public interface UserTransactionDao {

      void updateBalanceTransaction(double updatedBalance, int userId);

      void updateMetalTransaction(double updatedGoldQuantity, int userId, String metal);

     List<Double> metalValue(String metal);

     void addDataInTable(String id, int userId, String element, String mode, String status, Double quantity, Double value, String email);

      void updatedStatus(String id, String status);

      UserTransactionList getDetailsByName(int id);

      UserTransactionList getData();

      void refundTheMoney(int userId, double value);

       void refundTheMetal(int userId, double quantity, String metal);

       String getStatusFromTable(String id);

}
