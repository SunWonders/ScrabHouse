package com.sunwonders.trashman.dto;

import java.util.List;

import com.sunwonders.trashman.entities.Products;

public class ProductUpdateRequest {

	private String id;

	private List<Products> products;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}
}
