/**
 * 
 */
package com.sunwonders.trashman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.entities.NotificationTokens;
import com.sunwonders.trashman.repo.NotificationTokensRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationServiceImpl.
 *
 * @author dilipd
 */
@Service
public class NotificationServiceImpl implements NotificationService {

	/** The notification tokens repo. */
	@Autowired
	private NotificationTokensRepo notificationTokensRepo;

	/**
	 * Save token.
	 *
	 * @param notificationTokens the notification tokens
	 * @return the string
	 */
	@Override
	public String saveToken(NotificationTokens notificationTokens) {
		// TODO Auto-generated method stub
		return notificationTokensRepo.save(notificationTokens).getId();
	}

}
