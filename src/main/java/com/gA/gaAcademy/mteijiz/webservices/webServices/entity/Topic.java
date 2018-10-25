package com.gA.gaAcademy.mteijiz.webservices.webServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {

	// id
	@Id // este id es distinto al de la variable. Hacemos que la variable sea clave
		// primaria y autogenerada
		// no hace falta poner @column porque el id ya esta configurado para ser
		// considerado como una columna
	@GeneratedValue
	private int id;

	// title: quiero que quede en la tabla
	@Column(name = "title")
	private String title;

	// datePost
	@Column(name = "datePost")
	private Date datePost;

	// description
	@Column(name = "description")
	private String description;

	// author
	@Column(name = "author")
	private int author;

	public Topic() {

	}

	public Topic(String title, Date date, String description, int author) {
		super();
		//this.title = title;
		Date d = new Date();//el problema con esto es que el servidor este en otro lado y se cree con otra zona horaria distinta a la que estas 
		this.datePost = d;
		this.datePost = date;
		this.description = description;
		this.author = author;
	}// alt + shift + s para hacer el constructor

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

}
