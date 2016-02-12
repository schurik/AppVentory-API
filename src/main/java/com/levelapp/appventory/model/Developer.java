/**
 * 
 */
package com.levelapp.appventory.model;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author alexander.buss
 *
 */
@Entity
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode
@ToString(of = { "name", "clientId", "clientKey" })
@Builder
@JsonIgnoreProperties({ "id", "clientKey" })
@NoArgsConstructor
@AllArgsConstructor
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String clientId;
	private String clientKey;
	private String email;
	private String name;

	@OneToMany
	private Set<App> apps;
}
