package com.uber.demo.services;



import com.uber.demo.beans.Account;
import com.uber.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service
public class AccountService extends ServiceInterface<Account>{
    private final AccountDao dao;
    @Autowired

    public AccountService(AccountDao dao) {
        this.dao = dao;
    }

    public List<Account> readAll() {
        return dao.getAllAccounts();
    }

    public Account read(long id){
        return dao.getAccount(id);
    }

    public Account login( Account account){
        return dao.accountCheck(account);
    }

    public Account create(Account entity){
        return dao.saveAccount(entity);
    }

    @Override
    public Account delete(long id) {
        return dao.deleteAccount(id);
    }

    public Account update(long id){
        return dao.updateAccount(id);
    }
}
