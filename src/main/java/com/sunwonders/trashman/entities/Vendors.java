package com.sunwonders.trashman.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class Vendors.
 */
@Document
public class Vendors {
	
	/** The id. */
	@Id
	private String id;

	/** The location. */
	private Location location;

	/** The vendor name. */
	private String vendorName;

	/** The phone number. */
	private String phoneNumber;

	/** The email id. */
	private String emailId;

	/** The user name. */
	@JsonInclude(Include.NON_NULL)
	private String userName;

	/** The password. */
	@JsonInclude(Include.NON_NULL)
	private String password;

	/** The products. */
	private List<Products> products;

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
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the vendor name.
	 *
	 * @return the vendor name
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Sets the vendor name.
	 *
	 * @param vendorName the new vendor name
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<Products> getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	public void setProducts(List<Products> products) {
		this.products = products;
	}

	/**
	 * Instantiates a new vendors.
	 *
	 * @param id the id
	 * @param location the location
	 * @param vendorName the vendor name
	 * @param phoneNumber the phone number
	 * @param emailId the email id
	 * @param userName the user name
	 * @param password the password
	 * @param products the products
	 */
	public Vendors(String id, Location location, String vendorName, String phoneNumber, String emailId, String userName,
			String password, List<Products> products) {
		super();
		this.id = id;
		this.location = location;
		this.vendorName = vendorName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.products = products;
	}

}
