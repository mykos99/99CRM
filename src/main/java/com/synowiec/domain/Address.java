package com.synowiec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address{
	@Id
	@GeneratedValue
	private long id;
	private String city;
	private String street;
	private String postalCode;
	private String country;
	
	public Address(){};
	
	public Address(String city, String postalCode, String street, String country) {
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", postalCode=" + postalCode
				+ ", country=" + country + "]";
	}

}
