package com.example.Spring.controller;

import com.example.Spring.protos.BuyRequestDto;
import com.example.Spring.protos.SellRequestDto;
import com.example.Spring.protos.TransactionList;
import com.example.Spring.protos.UserTransactionList;
import com.example.Spring.service.TransactionsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionsService transactionsService;

    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping(value = "/buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public TransactionList buyMetalTransaction(@RequestBody BuyRequestDto buyRequestDto) {
       return transactionsService.buyMetal(buyRequestDto);
    }

    @PostMapping(value = "/sell", produces = MediaType.APPLICATION_JSON_VALUE)
    public TransactionList sellMetalTransaction(@RequestBody SellRequestDto sellRequestDto) {
       return transactionsService.sellMetal(sellRequestDto);
    }

    @GetMapping(value = "/details", produces = MediaType.APPLICATION_JSON_VALUE) //
    public UserTransactionList getTransactionDetails() {
        return transactionsService.getDetailsByName();
    }
}
