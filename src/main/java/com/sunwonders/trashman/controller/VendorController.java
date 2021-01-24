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

import com.sunwonders.trashman.dto.ProductUpdateRequest;
import com.sunwonders.trashman.dto.ResponseModel;
import com.sunwonders.trashman.entities.Vendors;
import com.sunwonders.trashman.service.VendorsService;
import com.sunwonders.trashman.util.CommonStatusCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class VendorController.
 */
@RestController
@RequestMapping("/v1/vendor")
public class VendorController {

	/** The vendors service. */
	@Autowired
	private VendorsService vendorsService;

	/**
	 * Save.
	 *
	 * @param vendor the vendor
	 * @return the response entity
	 */
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final Vendors vendor) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = vendorsService.saveVendor(vendor);
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
	 * Gets the vendors by location.
	 *
	 * @param longitude the longitude
	 * @param latitude  the latitude
	 * @param distance  the distance
	 * @return the vendors by location
	 */
	@GetMapping(value = "/getVendorsByLocation")
	public ResponseEntity<List<Vendors>> getVendorsByLocation(@RequestParam double longitude,
			@RequestParam double latitude, @RequestParam double distance) {
		List<Vendors> result = new ArrayList<>();
		result = vendorsService.getVendorsByLocation(longitude, latitude, distance);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	/**
	 * Gets the vendors by distance.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @param distance the distance
	 * @return the vendors by distance
	 */
	@GetMapping(value = "/getVendorsByDistance")
	public ResponseEntity<ResponseModel> getVendorsByDistance(@RequestParam double longitude,
			@RequestParam double latitude, @RequestParam double distance) {
		List<Vendors> result = new ArrayList<>();
		ResponseModel userResponseModel = new ResponseModel();
		try {
			result = vendorsService.getVendorsByLocation(longitude, latitude, distance);
			if (result.isEmpty()) {
				userResponseModel.setStatusMessage("No Buyers are available");
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

	/**
	 * Vendor products update.
	 *
	 * @param productUpdateRequest the product update request
	 * @return the response entity
	 */
	@PostMapping(path = "/products/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> vendorProductsUpdate(
			@RequestBody final ProductUpdateRequest productUpdateRequest) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = vendorsService.updateVendorProducts(productUpdateRequest);
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
	 * Gets the vendors by id.
	 *
	 * @param id the id
	 * @return the vendors by id
	 */
	@GetMapping(value = "/getVendorsById")
	public ResponseEntity<ResponseModel> getVendorsById(@RequestParam String id) {
		Vendors result = null;
		ResponseModel userResponseModel = new ResponseModel();
		try {
			result = vendorsService.getVendorById(id);
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
