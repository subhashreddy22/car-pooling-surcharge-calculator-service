package com.car.pooling.surcharge.controller.model;

/**
 * The Class PriceDetails.
 */
public class PriceDetails {
	
	/** The base price. */
	private double basePrice;
	
	/** The surcharge price. */
	private double surchargePrice;
	
	/** The total price. */
	private double totalPrice;

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
	 * Gets the surcharge price.
	 *
	 * @return the surcharge price
	 */
	public double getSurchargePrice() {
		return surchargePrice;
	}

	/**
	 * Sets the surcharge price.
	 *
	 * @param surchargePrice the new surcharge price
	 */
	public void setSurchargePrice(double surchargePrice) {
		this.surchargePrice = surchargePrice;
	}

	/**
	 * Gets the total price.
	 *
	 * @return the total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Sets the total price.
	 *
	 * @param totalPrice the new total price
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Instantiates a new price details.
	 *
	 * @param basePrice the base price
	 * @param surchargePrice the surcharge price
	 * @param totalPrice the total price
	 */
	public PriceDetails(double basePrice, double surchargePrice, double totalPrice) {
		super();
		this.basePrice = basePrice;
		this.surchargePrice = surchargePrice;
		this.totalPrice = totalPrice;
	}
	
	
	
	
}
