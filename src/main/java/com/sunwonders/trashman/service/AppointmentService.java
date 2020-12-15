package com.sunwonders.trashman.service;

import java.util.List;

import com.sunwonders.trashman.dto.AppointmentUpdateRequest;
import com.sunwonders.trashman.entities.Appointments;

// TODO: Auto-generated Javadoc
/**
 * The Interface AppointmentService.
 */
public interface AppointmentService {

	/**
	 * Save appointment.
	 *
	 * @param appointment the appointment
	 * @return the string
	 */
	String saveAppointment(Appointments appointment);

	/**
	 * Find by vendor id.
	 *
	 * @param vendorId the vendor id
	 * @return the list
	 */
	List<Appointments> findByVendorId(String vendorId);

	/**
	 * Find by customer id.
	 *
	 * @param customerId the customer id
	 * @return the list
	 */
	List<Appointments> findByCustomerId(String customerId);

	/**
	 * Find by vendor id and status.
	 *
	 * @param vendorId the vendor id
	 * @param status   the status
	 * @return the list
	 */
	List<Appointments> findByVendorIdAndStatus(String vendorId, String status);

	/**
	 * Find by customer id and status.
	 *
	 * @param customerId the customer id
	 * @param status     the status
	 * @return the list
	 */
	List<Appointments> findByCustomerIdAndStatus(String customerId, String status);

	/**
	 * Update appointment status.
	 *
	 * @param appointmentUpdateRequest the appointment update request
	 * @return the string
	 */
	String updateAppointmentStatus(AppointmentUpdateRequest appointmentUpdateRequest);

	/**
	 * Find by appointment id.
	 *
	 * @param appointmentId the appointment id
	 * @return the appointments
	 */
	Appointments findByAppointmentId(String appointmentId);
}
