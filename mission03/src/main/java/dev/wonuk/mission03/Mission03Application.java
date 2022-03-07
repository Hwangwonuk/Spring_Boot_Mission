package dev.wonuk.mission03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Mission03Application {

	public static void main(String[] args) {
		SpringApplication.run(Mission03Application.class, args);
	}

}
