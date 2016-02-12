/**
 * 
 */
package com.levelapp.appventory.repository;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.levelapp.appventory.model.App;

/**
 * @author alexander.buss
 *
 */
public interface AppRepository extends PagingAndSortingRepository<App, Long> {

	Set<App> findByClientId(String clientId);

	App findByItunesId(String itunesId);
}
