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
import org.springframework.web.bind.annotation.RestController;

import com.sunwonders.trashman.dto.ResponseModel;
import com.sunwonders.trashman.entities.Products;
import com.sunwonders.trashman.service.ProductService;
import com.sunwonders.trashman.util.CommonStatusCodes;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductsController.
 */
@RestController
@RequestMapping("/v1/product")
public class ProductsController {

	/** The product service. */
	@Autowired
	private ProductService productService;

	/**
	 * Save.
	 * 
	 * @param product the product
	 * @return the response entity
	 */
	@PostMapping(path = "/save", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseModel> save(@RequestBody final Products product) {
		ResponseModel userResponseModel = new ResponseModel();
		try {
			String generatedId = productService.saveProduct(product);
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
	
	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<ResponseModel> getAllProducts() {
		List<Products> result = new ArrayList<>();
		ResponseModel userResponseModel = new ResponseModel();
		try {
			result = productService.getAllProducts();
			if (result.isEmpty()) {
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
