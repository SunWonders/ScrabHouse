package com.sunwonders.trashman.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunwonders.trashman.dto.AppointmentUpdateRequest;
import com.sunwonders.trashman.dto.ResponseModel;
import com.sunwonders.trashman.entities.Appointments;
import com.sunwonders.trashman.service.AppointmentService;
import com.sunwonders.trashman.util.CommonStatusCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class AppointmentController.
 */
@RestController
@RequestMapping("/v1/appointment")
public class AppointmentController {

	/** The appointment service. */
	@Autowired
	private AppointmentService appointmentService;

	/**
	 * Save.
	 *
	 * @param appointment the appointment
	 * @return the response entity
	 */
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final Appointments appointment) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = appointmentService.saveAppointment(appointment);
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
	 * Gets the vendor appointments by vendor id.
	 *
	 * @param id the id
	 * @return the vendor appointments by vendor id
	 */
	@GetMapping(value = "/getVendorAppointmentsByVendorId")
	public ResponseEntity<ResponseModel> getVendorAppointmentsByVendorId(@RequestParam String id) {
		List<Appointments> results = new ArrayList<>();
		ResponseModel userResponseModel = new ResponseModel();
		try {
			results = appointmentService.findByVendorId(id);
			if (results.isEmpty()) {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_NO_DATA_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS_NO_DATA);
			} else {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
				userResponseModel.setData(results);
			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Gets the customer appointments by customer id.
	 *
	 * @param id the id
	 * @return the customer appointments by customer id
	 */
	@GetMapping(value = "/getCustomerAppointmentsByCustomerId")
	public ResponseEntity<ResponseModel> getCustomerAppointmentsByCustomerId(@RequestParam String id) {
		List<Appointments> results = new ArrayList<>();
		ResponseModel userResponseModel = new ResponseModel();
		try {
			results = appointmentService.findByCustomerId(id);
			if (results.isEmpty()) {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_NO_DATA_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS_NO_DATA);
			} else {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
				userResponseModel.setData(results);
			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Gets the customer appointments by customer id and status.
	 *
	 * @param id the id
	 * @param status the status
	 * @return the customer appointments by customer id and status
	 */
	@GetMapping(value = "/getCustomerAppointmentsByCustomerIdAndStatus")
	public ResponseEntity<ResponseModel> getCustomerAppointmentsByCustomerIdAndStatus(@RequestParam String id,
			@RequestParam String status) {
		List<Appointments> results = new ArrayList<>();
		ResponseModel userResponseModel = new ResponseModel();
		try {
			results = appointmentService.findByCustomerIdAndStatus(id, status);
			if (results.isEmpty()) {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_NO_DATA_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS_NO_DATA);
			} else {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
				userResponseModel.setData(results);
			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Gets the vendor appointments by customer id and status.
	 *
	 * @param id the id
	 * @param status the status
	 * @return the vendor appointments by customer id and status
	 */
	@GetMapping(value = "/getVendorAppointmentsByCustomerIdAndStatus")
	public ResponseEntity<ResponseModel> getVendorAppointmentsByCustomerIdAndStatus(@RequestParam String id,
			@RequestParam String status) {
		List<Appointments> results = new ArrayList<>();
		ResponseModel userResponseModel = new ResponseModel();
		try {
			results = appointmentService.findByVendorIdAndStatus(id, status);
			if (results.isEmpty()) {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_NO_DATA_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS_NO_DATA);
			} else {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
				userResponseModel.setData(results);
			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * Update appointment status.
	 *
	 * @param appointmentUpdateRequest the appointment update request
	 * @return the response entity
	 */
	@PostMapping(path = "/updateAppointmentStatus", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> updateAppointmentStatus(
			@RequestBody final AppointmentUpdateRequest appointmentUpdateRequest) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = appointmentService.updateAppointmentStatus(appointmentUpdateRequest);
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
	 * Gets the appointment by appointment id.
	 *
	 * @param id the id
	 * @return the appointment by appointment id
	 */
	@GetMapping(value = "/getAppointmentByAppointmentId")
	public ResponseEntity<ResponseModel> getAppointmentByAppointmentId(@RequestParam String id) {
		Appointments result = null;
		ResponseModel userResponseModel = new ResponseModel();
		try {
			result = appointmentService.findByAppointmentId(id);
			if (result == null) {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_NO_DATA_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS_NO_DATA);
			} else {
				userResponseModel.setStatusMessage(CommonStatusCodes.SUCCESS_MESSAGE);
				userResponseModel.setStatusCode(CommonStatusCodes.SUCCESS);
				userResponseModel.setData(result);
			}
			return new ResponseEntity<>(userResponseModel, HttpStatus.OK);
		} catch (Exception e) {
			userResponseModel.setStatusMessage(e.getLocalizedMessage());
			userResponseModel.setStatusCode(CommonStatusCodes.FAILURE);
			return new ResponseEntity<>(userResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
