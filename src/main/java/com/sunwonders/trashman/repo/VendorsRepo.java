package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Vendors;

/**
 * The Interface VendorsRepo.
 */
public interface VendorsRepo extends CrudRepository<Vendors, String>{
	Vendors findByUserName(String userName);
}
