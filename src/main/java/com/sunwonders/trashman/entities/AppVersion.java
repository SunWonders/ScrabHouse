package com.sunwonders.trashman.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class AppVersion.
 */
@Document
public class AppVersion {
	/** The id. */
	@Id
	private String id;

	/** The version. */
	private String version;

	/** The type of app. */
	private String typeOfApp;

	/** The application. */
	private String application;

	/** The is active. */
	private Boolean isActive;

	/** The inserted date time. */
	private Date insertedDateTime;

	/** The updated date time. */
	private Date updatedDateTime;

	/**
	 * Gets the inserted date time.
	 *
	 * @return the inserted date time
	 */
	public Date getInsertedDateTime() {
		return insertedDateTime;
	}

	/**
	 * Sets the inserted date time.
	 *
	 * @param insertedDateTime the new inserted date time
	 */
	public void setInsertedDateTime(Date insertedDateTime) {
		this.insertedDateTime = insertedDateTime;
	}

	/**
	 * Gets the updated date time.
	 *
	 * @return the updated date time
	 */
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	/**
	 * Sets the updated date time.
	 *
	 * @param updatedDateTime the new updated date time
	 */
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
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

	/**
	 * Gets the checks if is active.
	 *
	 * @return the checks if is active
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * Sets the checks if is active.
	 *
	 * @param isActive the new checks if is active
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

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

}
