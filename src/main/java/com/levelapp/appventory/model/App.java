/**
 * 
 */
package com.levelapp.appventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author alexander.buss
 *
 */
@Entity
@Data
@EqualsAndHashCode
@ToString
public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	private String iTunesId;
	private String clientId;

	protected App() {
	}

	public App(String iTunesId, String clientId) {
		super();
		this.iTunesId = iTunesId;
		this.clientId = clientId;
	}

}
