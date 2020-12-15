package com.sunwonders.trashman.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Appointments;

// TODO: Auto-generated Javadoc
/**
 * The Interface AppointmentsRepo.
 */
public interface AppointmentsRepo extends CrudRepository<Appointments, String> {
	
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
	 * @param status the status
	 * @return the list
	 */
	List<Appointments> findByVendorIdAndStatus(String vendorId, String status);

	/**
	 * Find by customer id and status.
	 *
	 * @param customerId the customer id
	 * @param status the status
	 * @return the list
	 */
	List<Appointments> findByCustomerIdAndStatus(String customerId, String status);
}
