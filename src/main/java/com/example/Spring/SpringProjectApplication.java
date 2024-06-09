package com.example.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringProjectApplication { public static void main(String[] args) {
	SpringApplication.run(SpringProjectApplication.class, args);
	}
}
