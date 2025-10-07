package com.analyzer.oracle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OracleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OracleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//oracleConnector.executeQuery();

		System.out.println("Running command liner");

	}

}
