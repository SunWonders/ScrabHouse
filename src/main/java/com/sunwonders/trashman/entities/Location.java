package com.sunwonders.trashman.entities;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

// TODO: Auto-generated Javadoc
/**
 * The Class Location.
 */
public class Location {
	
	/** The route. */
	String route;
	
	/** The locality. */
	String locality;
	
	/** The area 1. */
	String area1;
	
	/** The country. */
	String country;
	
	/** The postal code. */
	String postalCode;

	/** The location coord. */
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2D)
	double[] locationCoord;

	/**
	 * Gets the route.
	 *
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * Sets the route.
	 *
	 * @param route the new route
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * Gets the locality.
	 *
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * Sets the locality.
	 *
	 * @param locality the new locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * Gets the area 1.
	 *
	 * @return the area 1
	 */
	public String getArea1() {
		return area1;
	}

	/**
	 * Sets the area 1.
	 *
	 * @param area1 the new area 1
	 */
	public void setArea1(String area1) {
		this.area1 = area1;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Gets the location coord.
	 *
	 * @return the location coord
	 */
	public double[] getLocationCoord() {
		return locationCoord;
	}

	/**
	 * Sets the location coord.
	 *
	 * @param locationCoord the new location coord
	 */
	public void setLocationCoord(double[] locationCoord) {
		this.locationCoord = locationCoord;
	}

}
