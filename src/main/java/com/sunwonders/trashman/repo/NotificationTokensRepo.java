package com.sunwonders.trashman.repo;

import org.springframework.data.repository.CrudRepository;

import com.sunwonders.trashman.entities.NotificationTokens;

/**
 * The Interface NotificationTokensRepo.
 */
public interface NotificationTokensRepo extends CrudRepository<NotificationTokens, String> {

}
