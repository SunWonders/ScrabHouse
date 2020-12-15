package com.sunwonders.trashman.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunwonders.trashman.dto.AppointmentUpdateRequest;
import com.sunwonders.trashman.entities.Appointments;
import com.sunwonders.trashman.repo.AppointmentsRepo;
import com.sunwonders.trashman.util.CommonStatusCodes;

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
		appointment.setInsertedDateTime(new Date());
		appointment.setStatus(CommonStatusCodes.APPOINTMENT_BOOKED_BY_CUSTOMER);
		return appointmentsRepo.save(appointment).getId();
	}

	/**
	 * Find by vendor id.
	 *
	 * @param vendorId the vendor id
	 * @return the list
	 */
	@Override
	public List<Appointments> findByVendorId(String vendorId) {
		// TODO Auto-generated method stub
		return appointmentsRepo.findByVendorId(vendorId);
	}

	/**
	 * Find by customer id.
	 *
	 * @param customerId the customer id
	 * @return the list
	 */
	@Override
	public List<Appointments> findByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return appointmentsRepo.findByCustomerId(customerId);
	}

	/**
	 * Find by vendor id and status.
	 *
	 * @param vendorId the vendor id
	 * @param status the status
	 * @return the list
	 */
	@Override
	public List<Appointments> findByVendorIdAndStatus(String vendorId, String status) {
		// TODO Auto-generated method stub
		return appointmentsRepo.findByVendorIdAndStatus(vendorId, status);
	}

	/**
	 * Find by customer id and status.
	 *
	 * @param customerId the customer id
	 * @param status the status
	 * @return the list
	 */
	@Override
	public List<Appointments> findByCustomerIdAndStatus(String customerId, String status) {
		// TODO Auto-generated method stub
		return appointmentsRepo.findByCustomerIdAndStatus(customerId, status);
	}

	/**
	 * Update appointment status.
	 *
	 * @param appointmentUpdateRequest the appointment update request
	 * @return the string
	 */
	@Override
	public String updateAppointmentStatus(AppointmentUpdateRequest appointmentUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<Appointments> appointmentsData = appointmentsRepo
				.findById(appointmentUpdateRequest.getAppointmentId());
		if (appointmentsData.isPresent()) {
			Appointments appointments = appointmentsData.get();
			if (appointmentUpdateRequest.getVendorId() != null) {
				appointments.setVendorId(appointmentUpdateRequest.getVendorId());
			}
			if (appointmentUpdateRequest.getCustomerId() != null) {
				appointments.setCustomerId(appointmentUpdateRequest.getCustomerId());
			}
			if (appointmentUpdateRequest.getAppointmentDate() != null) {
				appointments.setAppointmentDate(appointmentUpdateRequest.getAppointmentDate());
			}
			appointments.setStatus(appointmentUpdateRequest.getStatus());
			appointments.setUpdatedDateTime(new Date());
			return appointmentsRepo.save(appointments).getId();
		} else {
			return null;
		}
	}

	/**
	 * Find by appointment id.
	 *
	 * @param appointmentId the appointment id
	 * @return the appointments
	 */
	@Override
	public Appointments findByAppointmentId(String appointmentId) {
		// TODO Auto-generated method stub
		Optional<Appointments> appointmentsData = appointmentsRepo.findById(appointmentId);
		if (appointmentsData.isPresent()) {
			return appointmentsData.get();
		} else {
			return null;
		}
	}

}
