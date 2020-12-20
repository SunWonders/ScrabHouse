package com.sunwonders.trashman.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.dto.ChangePasswordRequest;
import com.sunwonders.trashman.entities.Users;
import com.sunwonders.trashman.repo.UsersRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCredentialsServiceImpl.
 */
@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/**
	 * Change password.
	 *
	 * @param changePasswordRequest the change password request
	 * @return the string
	 */
	@Override
	public String changePassword(ChangePasswordRequest changePasswordRequest) {
		// TODO Auto-generated method stub

		Users user = usersRepository.findByUsername(changePasswordRequest.getUserName());
		if (user != null) {

			boolean oldPasswordCheck = new BCryptPasswordEncoder().matches(changePasswordRequest.getOldPassword(),
					user.getPassword());

			if (oldPasswordCheck & !changePasswordRequest.getNewPassword().isEmpty()) {
				user.setPassword(new BCryptPasswordEncoder().encode(changePasswordRequest.getNewPassword()));
				user.setUpdatedDateTime(new Date());
				return usersRepository.save(user).getId();
			}

		}

		return null;
	}

}
