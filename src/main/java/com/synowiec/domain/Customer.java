package com.synowiec.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String shortName;
    private String longName;
    private String email;
    private String telephone;
    private String fax;
    private String vat;
    private String regon;
    @ManyToOne
    private Address address;
    @ManyToOne
    private Employee salesman;
    @ManyToOne
    private CustomerType custType;
    @OneToMany(mappedBy = "customer")
    private List<Contact> contacts;

    public Customer() {
    }

    public Customer(String shortName, String longName, String email, String telephone, String fax,
                    String vat, String regon, Address address, Employee salesman, CustomerType custType) {
        this.shortName = shortName;
        this.longName = longName;
        this.email = email;
        this.telephone = telephone;
        this.fax = fax;
        this.vat = vat;
        this.regon = regon;
        this.address = address;
        this.salesman = salesman;
        this.custType = custType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getSalesman() {
        return salesman;
    }

    public void setSalesman(Employee salesman) {
        this.salesman = salesman;
    }

    public CustomerType getCustType() {
        return custType;
    }

    public void setCustType(CustomerType custType) {
        this.custType = custType;
    }

    public List<Contact> getContacts() {

        return contacts;
    }


    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "["+id+"] "+shortName;
    }
}
