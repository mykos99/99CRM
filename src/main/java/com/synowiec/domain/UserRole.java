package com.synowiec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeType{
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	public EmployeeType(){};
	
	public EmployeeType(String name){

		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "["+id+"] "+name;
	}
}
