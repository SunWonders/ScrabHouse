package com.sunwonders.trashman.dto;

import java.util.List;

import com.sunwonders.trashman.entities.Products;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductUpdateRequest.
 */
public class ProductUpdateRequest {

	/** The id. */
	private String id;

	/** The products. */
	private List<Products> products;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<Products> getProducts() {
		return products;
	}

	/**
	 * Sets the products.
	 *
	 * @param products the new products
	 */
	public void setProducts(List<Products> products) {
		this.products = products;
	}
}
