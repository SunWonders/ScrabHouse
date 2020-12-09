package com.sunwonders.trashman.service;

import java.util.List;

import com.sunwonders.trashman.entities.Products;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the string
	 */
	public String saveProduct(Products product);
	
	public List<Products> getAllProducts();
}
