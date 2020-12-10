package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Users;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsersRepository.
 */
public interface UsersRepository extends CrudRepository<Users, String> {

	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the users
	 */
	Users findByUsername(String username);

	Users findByUsernameAndPassword(String username, String password);
}