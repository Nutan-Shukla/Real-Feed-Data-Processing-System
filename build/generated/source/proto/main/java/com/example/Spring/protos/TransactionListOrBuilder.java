// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Transaction.proto

// Protobuf Java Version: 3.25.2
package com.example.Spring.protos;

public interface TransactionListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.Spring.Project.TransactionList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.example.Spring.Project.Transaction transaction = 1;</code>
   */
  java.util.List<com.example.Spring.protos.Transaction> 
      getTransactionList();
  /**
   * <code>repeated .com.example.Spring.Project.Transaction transaction = 1;</code>
   */
  com.example.Spring.protos.Transaction getTransaction(int index);
  /**
   * <code>repeated .com.example.Spring.Project.Transaction transaction = 1;</code>
   */
  int getTransactionCount();
  /**
   * <code>repeated .com.example.Spring.Project.Transaction transaction = 1;</code>
   */
  java.util.List<? extends com.example.Spring.protos.TransactionOrBuilder> 
      getTransactionOrBuilderList();
  /**
   * <code>repeated .com.example.Spring.Project.Transaction transaction = 1;</code>
   */
  com.example.Spring.protos.TransactionOrBuilder getTransactionOrBuilder(
      int index);
}
