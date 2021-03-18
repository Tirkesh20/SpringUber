package com.uber.demo;

import com.uber.demo.services.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private AccountService service;

//	@Autowired
//	public DemoApplication(AccountService accountService){
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
