package com.library.entities;

public class paraQuery {
private String title;
private String firstName;
private String secondName;

public paraQuery() {
}
public paraQuery(String title, String firstName, String secondName) {
	super();
	this.title = title;
	this.firstName = firstName;
	this.secondName = secondName;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
@Override
public String toString() {
	return "paraQuery [title=" + title + ", firstName=" + firstName + ", secondName=" + secondName + "]";
}


}
