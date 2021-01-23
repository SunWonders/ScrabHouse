package com.sunwonders.trashman.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class DynamicData.
 */
@Document
public class Products {

	/** The id. */
	@Id
	private String id;

	/** The product name. */
	private String productName;

	/** The product url. */
	private String productUrl;

	/** The type of unit. */
	private String typeOfUnit;

	/** The amount. */
	private Float amount;

	/** The start range. */
	private Float startRange;

	/** The end range. */
	private Float endRange;

	/** The price type. */
	private String priceType;

	

	public Float getStartRange() {
		return startRange;
	}

	public void setStartRange(Float startRange) {
		this.startRange = startRange;
	}

	public Float getEndRange() {
		return endRange;
	}

	public void setEndRange(Float endRange) {
		this.endRange = endRange;
	}

	/**
	 * Gets the price type.
	 *
	 * @return the price type
	 */
	public String getPriceType() {
		return priceType;
	}

	/**
	 * Sets the price type.
	 *
	 * @param priceType the new price type
	 */
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	/**
	 * Gets the type of unit.
	 *
	 * @return the type of unit
	 */
	public String getTypeOfUnit() {
		return typeOfUnit;
	}

	/**
	 * Sets the type of unit.
	 *
	 * @param typeOfUnit the new type of unit
	 */
	public void setTypeOfUnit(String typeOfUnit) {
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
	 * Instantiates a new products.
	 *
	 * @param id          the id
	 * @param productName the product name
	 * @param productUrl  the product url
	 */
	public Products(String id, String productName, String productUrl) {
		super();
		this.id = id;
		this.productName = productName;
		this.productUrl = productUrl;
	}

}
