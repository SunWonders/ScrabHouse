package com.sunwonders.trashman.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.AppVersion;

// TODO: Auto-generated Javadoc
/**
 * The Interface VersionCheckRepo.
 */
public interface VersionCheckRepo extends CrudRepository<AppVersion, String> {

	/**
	 * Find by version and type of app and application.
	 *
	 * @param version     the version
	 * @param typeOfApp   the type of app
	 * @param application the application
	 * @return the list
	 */
	List<AppVersion> findByVersionAndTypeOfAppAndApplication(String version, String typeOfApp, String application);

	/**
	 * Find by version and type of app and application and vendor id.
	 *
	 * @param version the version
	 * @param typeOfApp the type of app
	 * @param application the application
	 * @param vendorId the vendor id
	 * @return the list
	 */
	List<AppVersion> findByVersionAndTypeOfAppAndApplicationAndVendorId(String version, String typeOfApp,
			String application, String vendorId);
}
