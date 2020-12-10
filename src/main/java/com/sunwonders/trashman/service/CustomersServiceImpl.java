package com.sunwonders.trashman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.entities.Customers;
import com.sunwonders.trashman.entities.Users;
import com.sunwonders.trashman.repo.CustomersRepo;
import com.sunwonders.trashman.repo.UsersRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomersServiceImpl.
 */
@Service
public class CustomersServiceImpl implements CustomersService {

	/** The customers repo. */
	@Autowired
	private CustomersRepo customersRepo;

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the string
	 */
	@Override
	public String saveCustomer(Customers customer) {
		saveUserForAuthentication(customer);
		return customersRepo.save(customer).getId();
	}

	/**
	 * Save user for authentication.
	 *
	 * @param customer the customer
	 */
	private void saveUserForAuthentication(Customers customer) {
		if (customer.getId() == null && customer.getUserName() != null && customer.getPassword() != null) {
			Users usersData = usersRepository.findByUsername(customer.getUserName());
			if (usersData == null) {
				Users users = new Users();
				users.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
				users.setUsername(customer.getUserName());
				users.setIsEnabled(true);
				users.setTypeOfUser("CUSTOMER");
				users.setIsVerified(true);
				usersRepository.save(users);
			}
		}
		customer.setUserName(null);
		customer.setPassword(null);
	}

}
