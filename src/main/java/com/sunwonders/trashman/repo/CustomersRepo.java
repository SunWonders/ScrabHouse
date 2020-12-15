package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Customers;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomersRepo.
 */
public interface CustomersRepo extends CrudRepository<Customers, String> {
	
	/**
	 * Find by email id or phone number.
	 *
	 * @param emailId the email id
	 * @param phoneNumber the phone number
	 * @return the customers
	 */
	Customers findByEmailIdOrPhoneNumber(String emailId, String phoneNumber);

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the customers
	 */
	Customers findByUserName(String userName);
}
