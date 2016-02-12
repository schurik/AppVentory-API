/**
 * 
 */
package com.levelapp.appventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.levelapp.appventory.model.Developer;

/**
 * @author alexander.buss
 *
 */
public interface DeveloperRepository extends CrudRepository<Developer, Long> {

	Developer findByEmail(final String email);
}
