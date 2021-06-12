package com.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Authors")
public class Author {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int authorId;
private String firstName;
private String secondName;
private String language;
@OneToOne(mappedBy="author")
@JsonBackReference
private Books book;

public int getAuthorId() {
	return authorId;
}


public void setAuthorId(int authorId) {
	this.authorId = authorId;
}


public Books getBook() {
	return book;
}


public void setBook(Books book) {
	this.book = book;
}


public Author(int id, String firstName, String secondName, String language) {
	super();
	this.authorId = id;
	this.firstName = firstName;
	this.secondName = secondName;
	this.language = language;
}


public Author() {
	super();
}


public int getId() {
	return authorId;
}
public void setId(int id) {
	this.authorId = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getSecondName() {
	return secondName;
}
public void setSecondName(String secondName) {
	this.secondName = secondName;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}


}
