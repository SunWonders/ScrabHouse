package com.sunwonders.trashman.dto;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class AppointmentUpdateRequest.
 */
public class AppointmentUpdateRequest {
	
	/** The vendor id. */
	private String vendorId;

	/** The customer id. */
	private String customerId;

	/** The status. */
	private String status;

	/** The appointment id. */
	private String appointmentId;
	
	/** The appointment date. */
	private Date appointmentDate;

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
	 * Gets the appointment id.
	 *
	 * @return the appointment id
	 */
	public String getAppointmentId() {
		return appointmentId;
	}

	/**
	 * Sets the appointment id.
	 *
	 * @param appointmentId the new appointment id
	 */
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
}
