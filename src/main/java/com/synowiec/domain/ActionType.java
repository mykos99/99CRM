package com.synowiec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class ActionType {
	@javax.persistence.Id
	@GeneratedValue
	private long Id;
	private String name;
	
	public ActionType() {}
	
	public ActionType(String name) {
		this.name = name;
	}
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ActionType [Id=" + Id + ", name=" + name + "]";
	}
	
}
