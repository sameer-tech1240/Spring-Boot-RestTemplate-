package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplicationCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplicationCrudApplication.class, args);
		System.out.println("Application run successfully....");
	}

}
