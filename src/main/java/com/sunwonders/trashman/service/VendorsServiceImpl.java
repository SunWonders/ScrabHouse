package com.sunwonders.trashman.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.dto.ProductUpdateRequest;
import com.sunwonders.trashman.entities.Users;
import com.sunwonders.trashman.entities.Vendors;
import com.sunwonders.trashman.repo.UsersRepository;
import com.sunwonders.trashman.repo.VendorsRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class VendorsServiceImpl.
 */
@Service
public class VendorsServiceImpl implements VendorsService {

	/** The vendors repo. */
	@Autowired
	private VendorsRepo vendorsRepo;

	/** The mongo operations. */
	@Autowired
	private MongoOperations mongoOperations;

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Save vendor.
	 *
	 * @param vendor the vendor
	 * @return the string
	 */
	@Override
	public String saveVendor(Vendors vendor) {
		// TODO Auto-generated method stub
		if ((vendor.getUserName() != null && !vendor.getUserName().isEmpty())
				&& ((vendor.getEmailId() != null && !vendor.getEmailId().isEmpty())
						|| (vendor.getPhoneNumber() != null && !vendor.getPhoneNumber().isEmpty()))) {
			saveUserForAuthentication(vendor);

			Vendors vendorsDbObj = vendorsRepo.findByUserName(vendor.getUserName());
			if (vendorsDbObj != null) {
				vendor.setId(vendorsDbObj.getId());
				vendor.setInsertedDateTime(vendorsDbObj.getInsertedDateTime());
				modelMapper.map(vendor, vendorsDbObj);
				
				vendor.setUpdatedDateTime(new Date());
			} else {
				vendor.setInsertedDateTime(new Date());
			}
			
			return vendorsRepo.save(vendor).getId();
		} else
		{
			return null;
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
	@Override
	public List<Vendors> getVendorsByLocation(double longitude, double latitude, double distance) {
		// TODO Auto-generated method stub
		List<Vendors> result = null;
		List<AggregationOperation> list = new ArrayList<AggregationOperation>();

		Point p = new Point(longitude, latitude);
		NearQuery nearQuery = NearQuery.near(p, Metrics.KILOMETERS).maxDistance(distance);
		list.add(Aggregation.geoNear(nearQuery, "distance"));
		// list.add(Aggregation.project("id", "location","vendorName"));
		TypedAggregation<Vendors> agg = newAggregation(Vendors.class, list);
		result = mongoOperations.aggregate(agg, Vendors.class).getMappedResults();
		return result;
	}

	/**
	 * Update vendor products.
	 *
	 * @param productUpdateRequest the product update request
	 * @return the string
	 */
	@Override
	public String updateVendorProducts(ProductUpdateRequest productUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<Vendors> vendorDetails = vendorsRepo.findById(productUpdateRequest.getId());
		if (vendorDetails.isPresent()) {
			Vendors vendor = vendorDetails.get();
			vendor.setProducts(productUpdateRequest.getProducts());
			return vendorsRepo.save(vendor).getId();
		} else {
			return null;
		}

	}

	/**
	 * Gets the vendor by id.
	 *
	 * @param vendorId the vendor id
	 * @return the vendor by id
	 */
	@Override
	public Vendors getVendorById(String vendorId) {
		// TODO Auto-generated method stub
		Optional<Vendors> vendorDetails = vendorsRepo.findById(vendorId);
		if (vendorDetails.isPresent()) {
			return vendorDetails.get();
		} else {
			return null;
		}

	}

	/**
	 * Save user for authentication.
	 *
	 * @param vendor the vendor
	 */
	private void saveUserForAuthentication(Vendors vendor) {
		if (vendor.getId() == null && vendor.getUserName() != null && vendor.getPassword() != null) {
			Users usersData = usersRepository.findByUsername(vendor.getUserName());
			if (usersData == null) {
				Users users = new Users();
				users.setPassword(new BCryptPasswordEncoder().encode(vendor.getPassword()));
				users.setUsername(vendor.getUserName());
				users.setIsEnabled(true);
				users.setTypeOfUser("VENDOR");
				users.setIsVerified(true);
				usersRepository.save(users);
			}

		}

		vendor.setPassword(null);
	}

}
