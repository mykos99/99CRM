package com.synowiec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class ActionComment {

	@Id
	@GeneratedValue
	private long id;
	private Date date;
	private String comment;
	@ManyToOne
	private Action action;
	
	public ActionComment() {}
	
	public ActionComment(Date date, String comment, Action action) {
		this.date = date;
		this.comment = comment;
		this.action = action;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "ActionComment [id=" + id + ", date=" + date + ", comment=" + comment + ", action=" + action.toString() + "]";
	}
	
	

}
