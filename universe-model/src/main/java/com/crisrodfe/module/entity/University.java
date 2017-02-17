package com.crisrodfe.module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The Class University.
 */
@Entity
@Table(name="UNIVERSITY")
public class University {
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name="university_id")
	private Integer id;
	
	/** The university name. */
	@Column(name="university_name")
	@NotNull(message="Cannot be null")
	private String universityName;
	
	/** The university country. */
	@Column(name="university_country")
	@NotNull(message="Cannot be null")
	private String universityCountry;
	
	/** The university city. */
	@Column(name="university_city")
	@NotNull(message="Cannot be null")
	private String universityCity;
	
	/**
	 * Instantiates a new university.
	 */
	public University(){}

	/**
	 * Gets the university name.
	 *
	 * @return the university name
	 */
	public String getUniversityName() {
		return universityName;
	}

	/**
	 * Sets the university name.
	 *
	 * @param universityName the new university name
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	/**
	 * Gets the university country.
	 *
	 * @return the university country
	 */
	public String getUniversityCountry() {
		return universityCountry;
	}

	/**
	 * Sets the university country.
	 *
	 * @param universityCountry the new university country
	 */
	public void setUniversityCountry(String universityCountry) {
		this.universityCountry = universityCountry;
	}

	/**
	 * Gets the university city.
	 *
	 * @return the university city
	 */
	public String getUniversityCity() {
		return universityCity;
	}

	/**
	 * Sets the university city.
	 *
	 * @param universityCity the new university city
	 */
	public void setUniversityCity(String universityCity) {
		this.universityCity = universityCity;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Instantiates a new university.
	 *
	 * @param universityName the university name
	 * @param universityCountry the university country
	 * @param universityCity the university city
	 */
	public University(String universityName, String universityCountry, String universityCity) {
		super();
		this.universityName = universityName;
		this.universityCountry = universityCountry;
		this.universityCity = universityCity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getUniversityName();
	}
}
