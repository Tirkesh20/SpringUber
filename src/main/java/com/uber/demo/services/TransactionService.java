package com.uber.demo.services;


import com.uber.demo.beans.Transaction;
import com.uber.demo.dao.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends ServiceInterface<Transaction>{
    private final TransactionDao transactionDao;

    @Autowired
    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public Transaction create(Transaction entity){
        return transactionDao.saveTransaction(entity);
    }

    @Override
    public Transaction delete(long id){
        return  transactionDao.deleteTransaction(id);
    }

    @Override
    public List<Transaction> readAll() {
        return transactionDao.getAllTransactions();
    }

    @Override
    public Transaction read(long id){
        return transactionDao.getTransaction(id);
    }

    @Override
    public Transaction update(long id) {
        return transactionDao.updateTransaction(id);
    }
}

