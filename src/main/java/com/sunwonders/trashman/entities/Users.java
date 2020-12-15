package com.sunwonders.trashman.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Users.
 */
@Document
public class Users {

	/** The id. */
	@Id
	private String id;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/** The is enabled. */
	private Boolean isEnabled;

	/** The is verified. */
	private Boolean isVerified;

	/** The type of user. */
	private String typeOfUser;

	/**
	 * Gets the checks if is enabled.
	 *
	 * @return the checks if is enabled
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * Sets the checks if is enabled.
	 *
	 * @param isEnabled the new checks if is enabled
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * Gets the checks if is verified.
	 *
	 * @return the checks if is verified
	 */
	public Boolean getIsVerified() {
		return isVerified;
	}

	/**
	 * Sets the checks if is verified.
	 *
	 * @param isVerified the new checks if is verified
	 */
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * Gets the type of user.
	 *
	 * @return the type of user
	 */
	public String getTypeOfUser() {
		return typeOfUser;
	}

	/**
	 * Sets the type of user.
	 *
	 * @param typeOfUser the new type of user
	 */
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
