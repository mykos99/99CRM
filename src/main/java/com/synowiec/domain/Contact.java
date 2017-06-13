package com.synowiec.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String position;
    private String telephone;
    private String email;
    @ManyToOne
    private Customer customer;

    public Contact() {
    }

    ;

    public Contact(String firstName, String lastName, String position, String telephone, String email,
                   Customer customer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.telephone = telephone;
        this.email = email;
        this.customer = customer;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
                + ", telephone=" + telephone + ", email=" + email + ", customer=" + customer.toString() + "]";
    }

}
