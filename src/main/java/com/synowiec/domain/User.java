package com.synowiec.domain;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private String position;
	private String email;
	private String telephone;
	@ManyToOne
	private EmployeeType empType;
	
	public Employee(){};
	
	public Employee(String firstName, String lastName, String position, String email, String telephone,
			EmployeeType empType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.email = email;
		this.telephone = telephone;
		this.empType = empType;
	}


	
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public EmployeeType getEmpType() {
		return empType;
	}
	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}
	@Override
	public String toString() {
		return "["+id+"] "+firstName+" "+lastName+" - "+position+" - "+empType.getName();
	}

}
