package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Products;

/**
 * The Interface ProductsRepo.
 */
public interface ProductsRepo extends CrudRepository<Products, String> {

}
