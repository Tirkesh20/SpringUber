package com.uber.demo.controller;

import com.uber.demo.beans.Transaction;
import com.uber.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class TransactionController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("transactions/create/")
    public Transaction create(@Valid Transaction transactions){
        return transactionService.create(transactions);
    }

    @GetMapping("/transactions/all")
    public List<Transaction> readAll(){
        return transactionService.readAll();
    }
    @GetMapping("/transaction/read/{id}")

    public Transaction read(@PathVariable("id")Long id){
        return transactionService.read(id);
    }

    @PatchMapping("/transactions/update/{id}")
    public Transaction update(@PathVariable("id") Long id) {
        return transactionService.update(id);
    }

    @DeleteMapping("/transactions/delete/{id}")
    public Transaction delete(@PathVariable("id") Long id) {
        return transactionService.delete(id);
    }

}
