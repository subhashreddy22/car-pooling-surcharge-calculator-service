package com.car.pooling.surcharge.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.car.pooling.surcharge.config.ApplicationProperties;
import com.car.pooling.surcharge.controller.model.CarPriceDetails;
import com.car.pooling.surcharge.controller.model.PriceDetails;

/**
 * The Class SurchargeController.
 */
@RestController
public class SurchargeController {
	
	/**
	 * The properties.
	 * This autowires the properties from application.yml to this class.
	 * 
	 */
	@Autowired
	private ApplicationProperties properties;
	
	/** 
	 * The rest template.
	 * 
	 * This is the library provided by Spring Boot 
	 * to communicate with other rest services.
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/** 
	 * The car details url.
	 * @Value is used to fetch the details from application.yml
	 * The url for fetching the car price details will be injected in to the field
	 */
	@Value("${car.details.url}")
	private String carDetailsUrl;
	
	/**
	 * Gets the price details.
	 * Receives noOfDays and FIN as input
	 * Returns the Price Details like basePrice, surchargePrice, totalPrice
	 * 
	 * This a GET method with URI /car/pooling/surcharge
	 * Please refer README.md for further info
	 * 
	 * @param noOfDays the no of days
	 * @param FIN the fin
	 * @return the price details
	 */
	@GetMapping(value = "/car/pooling/surcharge", produces = MediaType.APPLICATION_JSON_VALUE)
	public PriceDetails getPriceDetails(@RequestParam int noOfDays,
			@RequestParam String FIN) {
		// create a httpEntity which is required for REST communication
		HttpEntity<String> httpEntity = new HttpEntity<>(null);
		// REST communication with another service using restTemplate 
		// and fetching the required car data based on FIN
		ResponseEntity<CarPriceDetails> carEntity = restTemplate.exchange(carDetailsUrl, HttpMethod.GET, httpEntity,
				CarPriceDetails.class, FIN);
		// getting CarpriceDetails from the response entity retrieved above
		CarPriceDetails carPriceDetails = carEntity.getBody();
		// calling the getSurcharge method to get the surcharge percentage with the above retrieved price details
		int surcharge = this.getSurcharge(carPriceDetails.getEnginePower(), carPriceDetails.getLocation());
		// fetching basePrice per day
		double basePrice = carPriceDetails.getBasePrice();
		// calculating surcharge per day
		double surchargePerDay = (surcharge * basePrice) / 100;
		// calculating totalPrice
		double totalPrice = noOfDays * (basePrice + surchargePerDay);
		// creating a decimalFormat object to format prices with 2 decimal points precision
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		// constructs a PriceDetails object and return as output
		return new PriceDetails(basePrice, Double.parseDouble(numberFormat.format(surchargePerDay)),
				Double.parseDouble(numberFormat.format(totalPrice)));
	}
	
	/**
	 * Gets the surcharge percentage.
	 * 
	 * Method to get the surcharge percentage based on the enginePower and location
	 *
	 * @param enginePower the engine power
	 * @param location the location
	 * @return the surcharge
	 */
	private int getSurcharge(short enginePower, String location) {
		if (enginePower <= 140) {
			return properties.getLessThan140Map().get(location);
		} else if (enginePower > 140 && enginePower <= 200) {
			return properties.getLessThan200Map().get(location);
		} else if (enginePower > 200 && enginePower <= 320) {
			return properties.getLessThan320Map().get(location);
		} else if (enginePower > 320 && enginePower <= 400) {
			return properties.getLessThan400Map().get(location);
		} else {
			return properties.getGreaterThan400Map().get(location);
		}
	}
}
