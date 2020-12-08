package com.sunwonders.trashman.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Appointments.
 */
@Document
public class Appointments {
	
	/** The id. */
	@Id
	private String id;

	/** The vendor id. */
	private String vendorId;

	/** The customer id. */
	private String customerId;

	/** The appointment date. */
	private Date appointmentDate;

	/** The notes. */
	private String notes;

	/** The status. */
	private String status;

	/** The approximate amount. */
	private Float approximateAmount;

	/** The products. */
	private List<String> products;

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
	 * Gets the vendor id.
	 *
	 * @return the vendor id
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * Sets the vendor id.
	 *
	 * @param vendorId the new vendor id
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the appointment date.
	 *
	 * @return the appointment date
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * Sets the appointment date.
	 *
	 * @param appointmentDate the new appointment date
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the approximate amount.
	 *
	 * @return the approximate amount
	 */
	public Float getApproximateAmount() {
		return approximateAmount;
	}

	/**
	 * Sets the approximate amount.
	 *
	 * @param approximateAmount the new approximate amount
	 */
	public void setApproximateAmount(Float approximateAmount) {
		this.approximateAmount = approximateAmount;
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<String> getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	public void setProducts(List<String> products) {
		this.products = products;
	}

}
