package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	private SimpleStringProperty title;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty isbn;
	public Book(String title, String firstName, String lastName, String isbn) {
		this.title = new SimpleStringProperty(title);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.isbn = new SimpleStringProperty(isbn);
	}
	//getters
	public String getTitle() {
		return title.get();
	}
	public String getFirstName() {
		return firstName.get();
	}
	public String getlastName() {
		return lastName.get();
	}
	public String getisbn() {
		return isbn.get();
	}
	//setters 
	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title);
	}
	public void setFirstName(String firstName) {
		this.firstName = new SimpleStringProperty(firstName);
	}
	public void setlastName(String lastName) {
		this.lastName = new SimpleStringProperty(lastName);
	}
	public void setisbn(String isbn) {
		this.isbn = new SimpleStringProperty(isbn);
	}

	
}
