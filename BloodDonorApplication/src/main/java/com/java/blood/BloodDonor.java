package com.java.blood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BloodDonor {
	public static void main(String[] args) {
		SpringApplication.run(BloodDonor.class, args);
	}
}
