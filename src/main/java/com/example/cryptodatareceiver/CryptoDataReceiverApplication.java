package com.example.cryptodatareceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoDataReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoDataReceiverApplication.class, args);
	}

}
