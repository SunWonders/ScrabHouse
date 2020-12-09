package com.sunwonders.trashman.entities;

public class VendorProducts {
	private String id;

	/** The product name. */
	private String productName;

	/** The product url. */
	private String productUrl;

	/** The type of unit. */
	private Integer typeOfUnit;

	/** The amount. */
	private Float amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public Integer getTypeOfUnit() {
		return typeOfUnit;
	}

	public void setTypeOfUnit(Integer typeOfUnit) {
		this.typeOfUnit = typeOfUnit;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
