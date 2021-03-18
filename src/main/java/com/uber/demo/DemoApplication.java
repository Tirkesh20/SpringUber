package com.uber.demo;

import com.uber.demo.beans.Account;
import com.uber.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
//	private static AccountService service;
//	 public static String username="user";
//	public static String password="1234";
//	@Autowired
//	public DemoApplication(AccountService service){
//		this.service=service;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		Account account=service.login(username,password);
//		System.out.println(account);
	}


}
