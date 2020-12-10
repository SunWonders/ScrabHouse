package com.sunwonders.trashman.entities;

// TODO: Auto-generated Javadoc
/**
 * The Class VendorProducts.
 */
public class VendorProducts {
	
	/** The id. */
	private String id;

	/** The product name. */
	private String productName;

	/** The product url. */
	private String productUrl;

	/** The type of unit. */
	private Integer typeOfUnit;

	/** The amount. */
	private Float amount;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product url.
	 *
	 * @return the product url
	 */
	public String getProductUrl() {
		return productUrl;
	}

	/**
	 * Sets the product url.
	 *
	 * @param productUrl the new product url
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	/**
	 * Gets the type of unit.
	 *
	 * @return the type of unit
	 */
	public Integer getTypeOfUnit() {
		return typeOfUnit;
	}

	/**
	 * Sets the type of unit.
	 *
	 * @param typeOfUnit the new type of unit
	 */
	public void setTypeOfUnit(Integer typeOfUnit) {
		this.typeOfUnit = typeOfUnit;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
