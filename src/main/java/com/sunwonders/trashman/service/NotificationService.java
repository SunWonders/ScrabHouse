package com.sunwonders.trashman.service;

import com.sunwonders.trashman.entities.NotificationTokens;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationService.
 */
public interface NotificationService {
	
	/**
	 * Save token.
	 *
	 * @param notificationTokens the notification tokens
	 * @return the string
	 */
	String saveToken(NotificationTokens notificationTokens);
}
