package com.synowiec.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Action {

    @Id
    @GeneratedValue
    private long id;
    private Date startDate;
    private Date endDate;
    private String description;
    @ManyToOne
    private Contact contact;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee fromEmployee;
    @ManyToOne
    private Employee toEmployee;
    @ManyToOne
    private ActionType actionType;
    @OneToMany(mappedBy = "action")
    private List<ActionComment> actionComments;

    public Action() {
    }

    public Action(Date startDate, Date endDate, String description, Contact contact, Customer customer, Employee fromEmployee, Employee toEmployee, ActionType actionType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.contact = contact;
        this.customer = customer;
        this.fromEmployee = fromEmployee;
        this.toEmployee = toEmployee;
        this.actionType = actionType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getFromEmployee() {
        return fromEmployee;
    }

    public void setFromEmployee(Employee fromEmployee) {
        this.fromEmployee = fromEmployee;
    }

    public Employee getToEmployee() {
        return toEmployee;
    }

    public void setToEmployee(Employee toEmployee) {
        this.toEmployee = toEmployee;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public List<ActionComment> getActionComments() {
        return actionComments;
    }

    public void setActionComments(List<ActionComment> actionComments) {
        this.actionComments = actionComments;
    }
}
