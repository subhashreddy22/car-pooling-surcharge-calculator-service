package com.car.pooling.surcharge.controller.model;

/**
 * The Class CarPriceDetails.
 */
public class CarPriceDetails {
	
	/** The base price. */
	private double basePrice;
	
	/** The location. */
	private String location;
	
	/** The engine power. */
	private short enginePower;

	/**
	 * Gets the base price.
	 *
	 * @return the base price
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * Sets the base price.
	 *
	 * @param basePrice the new base price
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the engine power.
	 *
	 * @return the engine power
	 */
	public short getEnginePower() {
		return enginePower;
	}

	/**
	 * Sets the engine power.
	 *
	 * @param enginePower the new engine power
	 */
	public void setEnginePower(short enginePower) {
		this.enginePower = enginePower;
	}
	
}
