package com.sunwonders.trashman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunwonders.trashman.dto.LoginRequest;
import com.sunwonders.trashman.dto.ResponseModel;
import com.sunwonders.trashman.entities.Users;
import com.sunwonders.trashman.repo.UsersRepository;
import com.sunwonders.trashman.util.CommonStatusCodes;

@RestController
@RequestMapping("/v1")
public class LoginController {

	@Autowired
	private UsersRepository usersRepository;

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final LoginRequest loginRequest) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			Users user = usersRepository.findByUsername(loginRequest.getUsername());
			// new BCryptPasswordEncoder().encode(loginRequest.getPassword())
			if (user == null) {

				userResponseModel.setStatusMessage(CommonStatusCodes.UNAUTHORIZED_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.UNAUTHORIZED_STATUS);
				return new ResponseEntity<>(userResponseModel, HttpStatus.UNAUTHORIZED);
			} else {
				boolean status = new BCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword());
				if (status) {
					if (user.getTypeOfUser() != null && user.getTypeOfUser().equals("CUSTOMER")) {
						userResponseModel.setIsCustomer(true);
					}
					if (user.getTypeOfUser() != null && user.getTypeOfUser().equals("VENDOR")) {
						userResponseModel.setIsVendor(true);
					}
					if (user.getTypeOfUser() != null) {
						userResponseModel.setData(user);
					}
					userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
					userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
					return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
				} else {
					userResponseModel.setStatusMessage(CommonStatusCodes.UNAUTHORIZED_MESSAGE);
					userResponseModel.setStatusCode(CommonStatusCodes.UNAUTHORIZED_STATUS);
					return new ResponseEntity<>(userResponseModel, HttpStatus.UNAUTHORIZED);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
