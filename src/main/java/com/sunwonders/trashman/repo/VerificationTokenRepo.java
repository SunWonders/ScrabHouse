package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.VerificationToken;

public interface VerificationTokenRepo extends CrudRepository<VerificationToken, String> {

}
