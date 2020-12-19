package com.sunwonders.trashman.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationTokens.
 */
@Document
public class NotificationTokens {

	/** The token. */
	private String token;

	/** The type ofuser. */
	private String typeOfuser;

	/** The id. */
	@Id
	private String id;

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the type ofuser.
	 *
	 * @return the type ofuser
	 */
	public String getTypeOfuser() {
		return typeOfuser;
	}

	/**
	 * Sets the type ofuser.
	 *
	 * @param typeOfuser the new type ofuser
	 */
	public void setTypeOfuser(String typeOfuser) {
		this.typeOfuser = typeOfuser;
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

}
