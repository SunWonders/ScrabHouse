/**
 * 
 */
package com.sunwonders.trashman.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.dto.VersionCheckRequest;
import com.sunwonders.trashman.entities.AppVersion;
import com.sunwonders.trashman.repo.VersionCheckRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class VersionCheckServiceImpl.
 *
 * @author dilipd
 */
@Service
public class VersionCheckServiceImpl implements VersionCheckService {

	/** The version check repo. */
	@Autowired
	private VersionCheckRepo versionCheckRepo;

	/**
	 * Check app version is active.
	 *
	 * @param versionCheckRequest the version check request
	 * @return the boolean
	 */
	@Override
	public Boolean checkAppVersionIsActive(VersionCheckRequest versionCheckRequest) {
		// TODO Auto-generated method stub
		Boolean isActive = false;
		List<AppVersion> appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(
				versionCheckRequest.getVersion(), versionCheckRequest.getTypeOfApp(), versionCheckRequest.getApplication());
		if (!appVersions.isEmpty()) {
			isActive = appVersions.get(0).getIsActive();
		}
		return isActive;
	}

	/**
	 * Save.
	 *
	 * @param appVersion the app version
	 * @return the string
	 */
	@Override
	public String save(AppVersion appVersion) {
		// TODO Auto-generated method stub
		List<AppVersion> appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(appVersion.getVersion(),
				appVersion.getTypeOfApp(), appVersion.getApplication());
		if (appVersion.getId() != null && !appVersion.getId().isEmpty()) {
			appVersion.setInsertedDateTime(new Date());
		}
		if (!appVersions.isEmpty()) {
			appVersion.setUpdatedDateTime(new Date());
		}
		return versionCheckRepo.save(appVersion).getId();

	}

	/**
	 * Update app status.
	 *
	 * @param appVersion the app version
	 * @return the string
	 */
	@Override
	public String updateAppStatus(AppVersion appVersion) {
		// TODO Auto-generated method stub
		List<AppVersion> appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(appVersion.getVersion(),
				appVersion.getTypeOfApp(), appVersion.getApplication());
		if (!appVersions.isEmpty()) {
			AppVersion appVersionFromDb = appVersions.get(0);
			appVersionFromDb.setIsActive(appVersion.getIsActive());
			appVersionFromDb.setUpdatedDateTime(new Date());
			return versionCheckRepo.save(appVersionFromDb).getId();
		} else {
			return null;
		}
	}
}
