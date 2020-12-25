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
import com.sunwonders.trashman.dto.VerificationRequest;
import com.sunwonders.trashman.service.VersionCheckService;
import com.sunwonders.trashman.util.CommonStatusCodes;

@RestController
@RequestMapping("/v1/verify")
public class VerificationController {

	@Autowired
	private VersionCheckService mailSender;

	@PostMapping(path = "/send", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final VerificationRequest verificationRequest) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			mailSender.confirmRegistration(verificationRequest.getUserName(), verificationRequest.getEmailId());
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
