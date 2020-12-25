package com.sunwonders.trashman.service;

import com.sunwonders.trashman.dto.VersionCheckRequest;
import com.sunwonders.trashman.entities.AppVersion;

// TODO: Auto-generated Javadoc
/**
 * The Interface VersionCheckService.
 */
public interface VersionCheckService {

	/**
	 * Check app version is active.
	 *
	 * @param versionCheckRequest the version check request
	 * @return the boolean
	 */
	Boolean checkAppVersionIsActive(VersionCheckRequest versionCheckRequest);

	/**
	 * Save.
	 *
	 * @param appVersion the app version
	 * @return the string
	 */
	String save(AppVersion appVersion);

	/**
	 * Update app status.
	 *
	 * @param appVersion the app version
	 * @return the string
	 */
	String updateAppStatus(AppVersion appVersion);

	void confirmRegistration(String username, String emailId);
}
