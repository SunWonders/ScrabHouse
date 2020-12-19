package com.sunwonders.trashman.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class VersionCheckRequest.
 */
public class VersionCheckRequest {

	/** The version. */
	private String version;

	/** The type of app. */
	private String typeOfApp;

	/** The application. */
	private String application;

	/** The vendor id. */
	private String vendorId;

	/**
	 * Gets the vendor id.
	 *
	 * @return the vendor id
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * Sets the vendor id.
	 *
	 * @param vendorId the new vendor id
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Gets the type of app.
	 *
	 * @return the type of app
	 */
	public String getTypeOfApp() {
		return typeOfApp;
	}

	/**
	 * Sets the type of app.
	 *
	 * @param typeOfApp the new type of app
	 */
	public void setTypeOfApp(String typeOfApp) {
		this.typeOfApp = typeOfApp;
	}

	/**
	 * Gets the application.
	 *
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * Sets the application.
	 *
	 * @param application the new application
	 */
	public void setApplication(String application) {
		this.application = application;
	}

}
