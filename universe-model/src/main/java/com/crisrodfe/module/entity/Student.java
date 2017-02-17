package com.crisrodfe.module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Incluiremos anotaciones en las propiedades que actuarán como filtro y mostrarán un mensaje de aviso en caso de no cumplir las condiciones
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The Class Student.
 * Representa la tabla Student de la BD.
 */
@Entity
@Table(name="STUDENT")
public class Student 
{
	
	/** The id. 
	 * Valor autogenerado por la base de datos.
	 * */
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	/** The first name. */
	@NotNull(message="You have to specify a first name")
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@NotNull(message="You have to specify a last name")
	@Column(name="last_name")
	private String lastName;
	
	/** The age. */
	@NotNull(message="You have to specify the age")
	@Min(value=0,message="The minimum value is 0")
	@Max(value=100,message="The maximum value is 100")
	@Column(name="age")
	private Integer age;
	
	/** The gender. */
	@NotNull(message="Gender must be set")
	@Column(name="gender")
	private String gender;

	/** The university. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="university_id")
	@NotNull(message="University must not be null")
	private University university;
	
	
	/**
	 * Gets the university.
	 *
	 * @return the university
	 */
	public University getUniversity() {
		return university;
	}

	/**
	 * Sets the university.
	 *
	 * @param university the new university
	 */
	public void setUniversity(University university) {
		this.university = university;
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * toString() override method.
	 */
	@Override
	public String toString() {
		return firstName + " - " + lastName + " - " + age;
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param age the age
	 * @param gender the gender
	 */
	public Student(Integer id, String firstName, String lastName, Integer age, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	/**
	 * Instantiates a new student.
	 */
	public Student(){}
	
}
