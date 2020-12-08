package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.Appointments;

/**
 * The Interface AppointmentsRepo.
 */
public interface AppointmentsRepo extends CrudRepository<Appointments, String>{

}
