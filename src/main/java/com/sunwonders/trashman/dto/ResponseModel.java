package com.sunwonders.trashman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseModel.
 */
public class ResponseModel {

	/** The status code. */
	private Integer statusCode;

	/** The status message. */
	private String statusMessage;

	/** The data. */
	@JsonInclude(Include.NON_NULL)
	private Object data;
	
	/** The is vendor. */
	@JsonInclude(Include.NON_NULL)
	private Boolean isVendor;
	
	/** The is customer. */
	@JsonInclude(Include.NON_NULL)
	private Boolean isCustomer;
	
	/** The is active. */
	@JsonInclude(Include.NON_NULL)
	private Boolean isActive;

	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the new checks if is active
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the checks if is vendor.
	 *
	 * @return the checks if is vendor
	 */
	public Boolean getIsVendor() {
		return isVendor;
	}

	/**
	 * Sets the checks if is vendor.
	 *
	 * @param isVendor the new checks if is vendor
	 */
	public void setIsVendor(Boolean isVendor) {
		this.isVendor = isVendor;
	}

	/**
	 * Gets the checks if is customer.
	 *
	 * @return the checks if is customer
	 */
	public Boolean getIsCustomer() {
		return isCustomer;
	}

	/**
	 * Sets the checks if is customer.
	 *
	 * @param isCustomer the new checks if is customer
	 */
	public void setIsCustomer(Boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/** The saved id. */
	@JsonInclude(Include.NON_NULL)
	private String savedId;

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the status message.
	 *
	 * @return the status message
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * Sets the status message.
	 *
	 * @param statusMessage the new status message
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * Gets the saved id.
	 *
	 * @return the saved id
	 */
	public String getSavedId() {
		return savedId;
	}

	/**
	 * Sets the saved id.
	 *
	 * @param savedId the new saved id
	 */
	public void setSavedId(String savedId) {
		this.savedId = savedId;
	}

}
