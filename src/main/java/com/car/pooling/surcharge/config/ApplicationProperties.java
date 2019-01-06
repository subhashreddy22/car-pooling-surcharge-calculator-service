package com.car.pooling.surcharge.config;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The Class ApplicationProperties to read values form properties.
 */
@Component
@ConfigurationProperties
public class ApplicationProperties {

	/** The Constant LOGGER to log the data. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationProperties.class);

	/** 
	 * The less than 140 map.
	 * This contains surcharges for engine power less than 140
	 */
	private Map<String, Integer> lessThan140Map;

	/** 
	 * The less than 200 map.
	 * This contains surcharges for engine power less than 200
	 */ 
	private Map<String, Integer> lessThan200Map;

	/** 
	 * The less than 320 map.
	 * This contains surcharges for engine power less than 320
	 */ 
	private Map<String, Integer> lessThan320Map;

	/** 
	 * The less than 400 map.
	 * This contains surcharges for engine power less than 40
	 */ 
	private Map<String, Integer> lessThan400Map;

	/** 
	 * The less than 400 map.
	 * This contains surcharges for engine power greater than 400
	 */ 
	private Map<String, Integer> greaterThan400Map;

	public Map<String, Integer> getLessThan140Map() {
		return lessThan140Map;
	}

	public void setLessThan140Map(Map<String, Integer> lessThan140Map) {
		this.lessThan140Map = lessThan140Map;
	}

	public Map<String, Integer> getLessThan200Map() {
		return lessThan200Map;
	}

	public void setLessThan200Map(Map<String, Integer> lessThan200Map) {
		this.lessThan200Map = lessThan200Map;
	}

	public Map<String, Integer> getLessThan320Map() {
		return lessThan320Map;
	}

	public void setLessThan320Map(Map<String, Integer> lessThan320Map) {
		this.lessThan320Map = lessThan320Map;
	}

	public Map<String, Integer> getLessThan400Map() {
		return lessThan400Map;
	}

	public void setLessThan400Map(Map<String, Integer> lessThan400Map) {
		this.lessThan400Map = lessThan400Map;
	}

	public Map<String, Integer> getGreaterThan400Map() {
		return greaterThan400Map;
	}

	public void setGreaterThan400Map(Map<String, Integer> greaterThan400Map) {
		this.greaterThan400Map = greaterThan400Map;
	}

	/**
	 * Post construct.
	 * 
	 * To log all the surcharges
	 */
	@PostConstruct
	private void postConstruct() {
		LOGGER.info("{}", lessThan140Map);
		LOGGER.info("{}", lessThan200Map);
		LOGGER.info("{}", lessThan320Map);
		LOGGER.info("{}", lessThan400Map);
		LOGGER.info("{}", greaterThan400Map);
	}

}
