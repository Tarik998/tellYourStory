package com.example.ispovjesti;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IspovjestiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(IspovjestiApplication.class, args);

		//Seeder seeder = applicationContext.getBean(Seeder.class);
		//seeder.seed();
	}

}
