package com.sunwonders.trashman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunwonders.trashman.dto.ChangePasswordRequest;
import com.sunwonders.trashman.dto.ResponseModel;
import com.sunwonders.trashman.service.UserCredentialsService;
import com.sunwonders.trashman.util.CommonStatusCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

	/** The user credentials service. */
	@Autowired
	private UserCredentialsService userCredentialsService;

	/**
	 * Save.
	 *
	 * @param changePasswordRequest the change password request
	 * @return the response entity
	 */
	@PostMapping(path = "/changePassword", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final ChangePasswordRequest changePasswordRequest) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String savedId = userCredentialsService.changePassword(changePasswordRequest);
			if (savedId == null) {

				userResponseModel.setStatusMessage(CommonStatusCodes.FAILURE_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);

			} else {
				userResponseModel.setSavedId(savedId);
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);

			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
