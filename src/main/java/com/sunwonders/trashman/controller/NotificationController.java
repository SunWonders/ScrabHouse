package com.sunwonders.trashman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunwonders.trashman.dto.ResponseModel;
import com.sunwonders.trashman.entities.NotificationTokens;
import com.sunwonders.trashman.service.NotificationService;
import com.sunwonders.trashman.util.CommonStatusCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationController.
 */
@RestController
@RequestMapping("/v1/notification")
public class NotificationController {

	/** The notification service. */
	@Autowired
	private NotificationService notificationService;

	/**
	 * Save.
	 *
	 * @param notificationTokens the notification tokens
	 * @return the response entity
	 */
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final NotificationTokens notificationTokens) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = notificationService.saveToken(notificationTokens);
			if (generatedId == null) {
				userResponseModel.setStatusMessage(CommonStatusCodes.FAILURE_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			} else {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
				userResponseModel.setSavedId(generatedId);
			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
