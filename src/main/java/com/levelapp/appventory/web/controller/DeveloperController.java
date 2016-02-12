/**
 * 
 */
package com.levelapp.appventory.web.controller;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levelapp.appventory.model.App;
import com.levelapp.appventory.model.Developer;
import com.levelapp.appventory.repository.AppRepository;
import com.levelapp.appventory.repository.DeveloperRepository;

/**
 * @author alexander.buss
 *
 */
@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	private AppRepository appRepository;

	@Autowired
	private DeveloperRepository developerRepository;

	@RequestMapping(value = { "/{clientId}/apps" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Set<App> listAppsByClientId(@PathVariable String clientId) {

		Set<App> apps = appRepository.findByClientId(clientId);
		return apps;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.CREATED)
	public HttpEntity<Developer> register(@RequestBody Developer developer) {

		if (developerRepository.findByEmail(developer.getEmail()) != null) {
			HttpEntity<Developer> httpEntity = new HttpEntity<>(developer);
			return httpEntity;
		}

		developer.setClientId(UUID.randomUUID().toString());
		developer.setClientKey(UUID.randomUUID().toString());

		Developer saved = developerRepository.save(developer);

		return new HttpEntity<>(saved);
	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Set<Developer> listDevelopers() {

		Set<Developer> result = StreamSupport.stream(developerRepository.findAll().spliterator(), false)
				.collect(Collectors.toSet());
		return result;

	}
}
