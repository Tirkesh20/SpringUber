package com.uber.demo.controller;

import com.uber.demo.beans.Account;
import com.uber.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String main() {
        return "welcome"; //view
    }

    @GetMapping("/login")
    private Account login(String username, String password){
        return accountService.login(username,password);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Account> readAll() {
        return accountService.readAll();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", accountService.read(id));
        return "/2";
    }

    @PostMapping("/register")
    public ResponseEntity<Account> create(@RequestBody Account account){
        Account res = accountService.create(account);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/account/read/{id}")
    public Account read(@PathVariable("id") Long id){
        return accountService.read(id);
    }

    @PatchMapping("/account/update/{id}")
    public Account update(@PathVariable("id") Long id) {
        return accountService.update(id);
    }

    @DeleteMapping("/account/delete/{id}")
    public Account delete(@PathVariable("id") Long id) {
        return accountService.delete(id);
    }

}