package com.gA.gaAcademy.mteijiz.webservices.webServices.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class Reply {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private Date date;

	@Column(name = "Author")
	private int author;

	@JoinColumn(name = "topic")
	@ManyToOne(cascade = CascadeType.ALL)
	private Topic topic;

	public Reply(String description, Date date, int author, Topic topic) {
		super();
		this.description = description;
		this.date = date;
		this.author = author;
		this.topic = topic;
	}

	public Reply() {
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public void setId(int id) {
		this.id = id;
	}

}
