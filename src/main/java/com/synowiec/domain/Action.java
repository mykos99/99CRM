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
    private User fromUser;
    @ManyToOne
    private User toUser;
    @ManyToOne
    private ActionType actionType;
    @OneToMany(mappedBy = "action")
    private List<ActionComment> actionComments;

    public Action() {
    }

    public Action(Date startDate, Date endDate, String description, Contact contact, Customer customer, User fromUser, User toUser, ActionType actionType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.contact = contact;
        this.customer = customer;
        this.fromUser = fromUser;
        this.toUser = toUser;
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

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
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
