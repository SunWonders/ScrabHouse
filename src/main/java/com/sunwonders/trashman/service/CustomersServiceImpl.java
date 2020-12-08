package com.sunwonders.trashman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.entities.Customers;
import com.sunwonders.trashman.repo.CustomersRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomersServiceImpl.
 */
@Service
public class CustomersServiceImpl implements CustomersService {

	/** The customers repo. */
	@Autowired
	private CustomersRepo customersRepo;

	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the string
	 */
	@Override
	public String saveCustomer(Customers customer) {
		// TODO Auto-generated method stub
		return customersRepo.save(customer).getId();
	}

}
