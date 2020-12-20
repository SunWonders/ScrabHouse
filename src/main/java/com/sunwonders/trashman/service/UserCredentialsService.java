package com.sunwonders.trashman.service;

import com.sunwonders.trashman.dto.ChangePasswordRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserCredentialsService.
 */
public interface UserCredentialsService {

	/**
	 * Change password.
	 *
	 * @param changePasswordRequest the change password request
	 * @return the string
	 */
	String changePassword(ChangePasswordRequest changePasswordRequest);
}
