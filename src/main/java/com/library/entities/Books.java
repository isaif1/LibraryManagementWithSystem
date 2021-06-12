package com.library.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="books")
public class Books {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String title;
private int availableCopy;
private int borrowedCopy;
@OneToOne(cascade=CascadeType.ALL)
@JsonManagedReference
private Author author;


public Books(int id, String title, int availableCopy, int borrowedCopy, Author author) {
	super();
	this.id = id;
	this.title = title;
	this.availableCopy = availableCopy;
	this.borrowedCopy = borrowedCopy;
	this.author = author;
}

public Books() {
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public int getAvailableCopy() {
	return availableCopy;
}

public void setAvailableCopy(int availableCopy) {
	this.availableCopy = availableCopy;
}

public int getBorrowedCopy() {
	return borrowedCopy;
}


public void setBorrowedCopy(int borrowedCopy) {
	this.borrowedCopy = borrowedCopy;
}

public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}
}
