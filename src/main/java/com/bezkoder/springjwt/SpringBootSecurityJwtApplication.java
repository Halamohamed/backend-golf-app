package com.bezkoder.springjwt;

import com.bezkoder.springjwt.models.ClientRegister;
import com.bezkoder.springjwt.repository.ClientRepository;
import org.hibernate.type.BlobType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;

import java.util.List;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {
	 static ClientRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);

	}




}
