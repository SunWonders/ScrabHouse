package com.sunwonders.trashman.service;

import com.sunwonders.trashman.entities.Customers;

// TODO: Auto-generated Javadoc
/**
 * The Interface CustomersService.
 */
public interface CustomersService {

	 /**
 	 * Save customer.
 	 *
 	 * @param customer the customer
 	 * @return the string
 	 */
 	String saveCustomer(Customers customer);

	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 */
	Customers getCustomerById(String id);
}
