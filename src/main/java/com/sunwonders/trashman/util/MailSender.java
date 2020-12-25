package com.sunwonders.trashman.util;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.sunwonders.trashman.entities.VerificationToken;
import com.sunwonders.trashman.repo.VerificationTokenRepo;

@Component
public class MailSender {
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
