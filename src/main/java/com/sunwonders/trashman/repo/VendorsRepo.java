package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Vendors;

// TODO: Auto-generated Javadoc
/**
 * The Interface VendorsRepo.
 */
public interface VendorsRepo extends CrudRepository<Vendors, String>{
	
	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the vendors
	 */
	Vendors findByUserName(String userName);
}
