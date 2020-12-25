/**
 * 
 */
package com.sunwonders.trashman.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.dto.VersionCheckRequest;
import com.sunwonders.trashman.entities.AppVersion;
import com.sunwonders.trashman.entities.VerificationToken;
import com.sunwonders.trashman.repo.VerificationTokenRepo;
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
//		List<AppVersion> appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(
//				versionCheckRequest.getVersion(), versionCheckRequest.getTypeOfApp(),
//				versionCheckRequest.getApplication());

		List<AppVersion> appVersions = new ArrayList<>();

		if (versionCheckRequest.getVendorId() != null) {
			appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplicationAndVendorId(
					versionCheckRequest.getVersion(), versionCheckRequest.getTypeOfApp(),
					versionCheckRequest.getApplication(), versionCheckRequest.getVendorId());
		} else {
			appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(versionCheckRequest.getVersion(),
					versionCheckRequest.getTypeOfApp(), versionCheckRequest.getApplication());
		}

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
		List<AppVersion> appVersions = new ArrayList<>();
		if (appVersion.getVendorId() != null) {
			appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplicationAndVendorId(appVersion.getVersion(),
					appVersion.getTypeOfApp(), appVersion.getApplication(), appVersion.getVendorId());
		} else {
			appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(appVersion.getVersion(),
					appVersion.getTypeOfApp(), appVersion.getApplication());
		}

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
		List<AppVersion> appVersions = new ArrayList<>();

		if (appVersion.getVendorId() != null) {
			appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplicationAndVendorId(appVersion.getVersion(),
					appVersion.getTypeOfApp(), appVersion.getApplication(), appVersion.getVendorId());
		} else {
			appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(appVersion.getVersion(),
					appVersion.getTypeOfApp(), appVersion.getApplication());
		}

//		appVersions = versionCheckRepo.findByVersionAndTypeOfAppAndApplication(appVersion.getVersion(),
//				appVersion.getTypeOfApp(), appVersion.getApplication());
		if (!appVersions.isEmpty()) {
			AppVersion appVersionFromDb = appVersions.get(0);
			appVersionFromDb.setIsActive(appVersion.getIsActive());
			appVersionFromDb.setUpdatedDateTime(new Date());
			return versionCheckRepo.save(appVersionFromDb).getId();
		} else {
			return null;
		}
	}

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VerificationTokenRepo verificationTokenRepo;

	public void confirmRegistration(String username, String emailId) {

		String token = UUID.randomUUID().toString();
		createVerificationToken(username, token);

		String recipientAddress = emailId;
		String subject = "Registration Confirmation";
		String confirmationUrl =
				// event.getAppUrl() +
				"/regitrationConfirm.html?token=" + token;
		String message = "Successfully Registered";

		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + "\r\n" + "http://localhost:8080" + confirmationUrl);
		mailSender.send(email);
	}

	public void createVerificationToken(String user, String token) {
		VerificationToken myToken = new VerificationToken();
		myToken.setUserName(user);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, 1);

		myToken.setExpiryDate(new Date(cal.getTime().getTime()));
		myToken.setToken(token);
		verificationTokenRepo.save(myToken);
	}
}
