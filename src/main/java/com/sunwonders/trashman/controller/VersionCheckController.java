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
import com.sunwonders.trashman.dto.VersionCheckRequest;
import com.sunwonders.trashman.entities.AppVersion;
import com.sunwonders.trashman.service.VersionCheckService;
import com.sunwonders.trashman.util.CommonStatusCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class VersionCheckController.
 */
@RestController
@RequestMapping("/v1/versioncheck")
public class VersionCheckController {

	/** The version check service. */
	@Autowired
	private VersionCheckService versionCheckService;

	/**
	 * Save.
	 *
	 * @param appVersion the app version
	 * @return the response entity
	 */
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final AppVersion appVersion) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = versionCheckService.save(appVersion);
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

	/**
	 * Check app is active.
	 *
	 * @param versionCheckRequest the version check request
	 * @return the response entity
	 */
	@PostMapping(path = "/checkAppIsActive", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> checkAppIsActive(@RequestBody final VersionCheckRequest versionCheckRequest) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			Boolean isActive = versionCheckService.checkAppVersionIsActive(versionCheckRequest);

			userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
			userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
			userResponseModel.setIsActive(isActive);

			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Update.
	 *
	 * @param appVersion the app version
	 * @return the response entity
	 */
	@PostMapping(path = "/updateAppStatus", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> update(@RequestBody final AppVersion appVersion) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = versionCheckService.updateAppStatus(appVersion);
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
