package com.sunwonders.trashman.service;

import java.util.List;

import com.sunwonders.trashman.dto.ProductUpdateRequest;
import com.sunwonders.trashman.entities.Vendors;

// TODO: Auto-generated Javadoc
/**
 * The Interface VendorsService.
 */
public interface VendorsService {

	/**
	 * Save vendor.
	 *
	 * @param vendor the vendor
	 * @return the string
	 */
	String saveVendor(Vendors vendor);

	/**
	 * Gets the vendors by location.
	 *
	 * @param longitude the longitude
	 * @param latitude  the latitude
	 * @param distance  the distance
	 * @return the vendors by location
	 */
	public List<Vendors> getVendorsByLocation(double longitude, double latitude, double distance);

	/**
	 * Update vendor products.
	 *
	 * @param productUpdateRequest the product update request
	 * @return the string
	 */
	String updateVendorProducts(ProductUpdateRequest productUpdateRequest);
	
	/**
	 * Gets the vendor by id.
	 *
	 * @param vendorId the vendor id
	 * @return the vendor by id
	 */
	Vendors getVendorById(String vendorId);
}
