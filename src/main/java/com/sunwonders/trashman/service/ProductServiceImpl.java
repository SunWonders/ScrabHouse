package com.sunwonders.trashman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.entities.Products;
import com.sunwonders.trashman.repo.ProductsRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** The products repo. */
	@Autowired
	private ProductsRepo productsRepo;

	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the string
	 */
	@Override
	public String saveProduct(Products product) {
		// TODO Auto-generated method stub
		return productsRepo.save(product).getId();
	}

}
