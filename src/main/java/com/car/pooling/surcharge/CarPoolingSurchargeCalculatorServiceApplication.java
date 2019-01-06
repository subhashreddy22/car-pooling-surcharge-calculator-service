package com.car.pooling.surcharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The Class CarPoolingSurchargeCalculatorServiceApplication.
 */
@SpringBootApplication
public class CarPoolingSurchargeCalculatorServiceApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// This is the application class which runs the spring boot application
		SpringApplication.run(CarPoolingSurchargeCalculatorServiceApplication.class, args);
	}
	
	/**
	 * Rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	public RestTemplate restTemplate() {
		// creates a new RestTemplate object and returns it
		return new RestTemplate();
	}

}

