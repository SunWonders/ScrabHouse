package com.sunwonders.trashman.service;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the string
	 */
	@Override
	public String saveCustomer(Customers customer) {
		if ((customer.getUserName() != null && !customer.getUserName().isEmpty())
				&& ((customer.getEmailId() != null && !customer.getEmailId().isEmpty())
						|| (customer.getPhoneNumber() != null && !customer.getPhoneNumber().isEmpty()))) {
			saveUserForAuthentication(customer);
			Customers customersDbObj = customersRepo.findByUserName(customer.getUserName());
			if (customersDbObj != null) {
				customer.setId(customersDbObj.getId());
				customer.setInsertedDateTime(customersDbObj.getInsertedDateTime());
				modelMapper.map(customer, customersDbObj);
				customer.setUpdatedDateTime(new Date());
			} else {
				customer.setInsertedDateTime(new Date());
			}
			return customersRepo.save(customer).getId();
		} else {
			return null;
		}
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
				users.setInsertedDateTime(new Date());
				usersRepository.save(users);
			}
		}
		// customer.setUserName(null);
		customer.setPassword(null);
	}

	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 */
	@Override
	public Customers getCustomerById(String id) {
		// TODO Auto-generated method stub
		Optional<Customers> customerData = customersRepo.findById(id);
		if (customerData.isPresent()) {
			return customerData.get();
		} else {
			return null;
		}
	}

}
