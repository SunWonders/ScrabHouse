package com.sunwonders.trashman.service;

import java.util.List;

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
	 * @param latitude the latitude
	 * @param distance the distance
	 * @return the vendors by location
	 */
	public List<Vendors> getVendorsByLocation(double longitude, double latitude, double distance);
}
