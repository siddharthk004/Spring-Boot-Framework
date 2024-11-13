package com.jpa.test.bootjpaeg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;

@SpringBootApplication
@EntityScan("com.jpa.test.entities")
@EnableJpaRepositories("com.jpa.test.dao")
public class BootjpaegApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BootjpaegApplication.class, args);
        UserRepo userrepo = context.getBean(UserRepo.class);

		User userx = new User();
		userx.setName("Siddharth Satish kardile");
		userx.setCity("Pune");
		userx.setStatus("I am software Developer");

		User user2 = userrepo.save(userx);

		System.out.println(user2);

	}
}
