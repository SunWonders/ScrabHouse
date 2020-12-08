package com.sunwonders.trashman.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.entities.Vendors;
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

	/**
	 * Save vendor.
	 *
	 * @param vendor the vendor
	 * @return the string
	 */
	@Override
	public String saveVendor(Vendors vendor) {
		// TODO Auto-generated method stub
		return vendorsRepo.save(vendor).getId();
	}

	/**
	 * Gets the vendors by location.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @param distance the distance
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
		list.add(Aggregation.project("id", "location"));
		TypedAggregation<Vendors> agg = newAggregation(Vendors.class, list);
		result = mongoOperations.aggregate(agg, Vendors.class).getMappedResults();
		return result;
	}

}
