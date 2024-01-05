package br.com.labparadise.labbeach;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabbeachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabbeachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
