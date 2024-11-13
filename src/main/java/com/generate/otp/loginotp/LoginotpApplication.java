package com.generate.otp.loginotp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class LoginotpApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LoginotpApplication.class)
				.web(WebApplicationType.REACTIVE)
				.run(args);
	}
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

}
