package org.thinknear.s4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class S4Application {

	public static void main(String[] args) {
		SpringApplication.run(S4Application.class, args);
	}
}
