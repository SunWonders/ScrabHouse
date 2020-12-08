package com.sunwonders.trashman.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseModel.
 */
public class ResponseModel {

	/** The status code. */
	private Integer statusCode;
	
	/** The status message. */
	private String statusMessage;
	
	/** The saved id. */
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
