package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Customers;

/**
 * The Interface CustomersRepo.
 */
public interface CustomersRepo extends CrudRepository<Customers, String> {
	Customers findByEmailIdOrPhoneNumber(String emailId, String phoneNumber);

	Customers findByUserName(String userName);
}
