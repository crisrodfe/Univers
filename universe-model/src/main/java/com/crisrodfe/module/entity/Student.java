package com.crisrodfe.module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//Incluiremos anotaciones en las propiedades que actuarán como filtro y mostrarán un mensaje de aviso en caso de no cumplir las condiciones
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="STUDENT")
public class Student 
{
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@NotNull(message="You have to specify a first name")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="You have to specify a last name")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="You have to specify the age")
	@Min(value=0,message="The minimum value is 0")
	@Max(value=100,message="The maximum value is 100")
	@Column(name="age")
	private Integer age;
	
	@NotNull(message="Gender must be set")
	@Column(name="gender")
	private String gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return firstName + " - " + lastName + " - " + age;
	}

	public Student(Integer id, String firstName, String lastName, Integer age, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	public Student(){}
	
}