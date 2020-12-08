package com.sunwonders.trashman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.entities.Appointments;
import com.sunwonders.trashman.repo.AppointmentsRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class AppointmentServiceImpl.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

	/** The appointments repo. */
	@Autowired
	private AppointmentsRepo appointmentsRepo;

	/**
	 * Save appointment.
	 *
	 * @param appointment the appointment
	 * @return the string
	 */
	@Override
	public String saveAppointment(Appointments appointment) {
		// TODO Auto-generated method stub
		return appointmentsRepo.save(appointment).getId();
	}

}
