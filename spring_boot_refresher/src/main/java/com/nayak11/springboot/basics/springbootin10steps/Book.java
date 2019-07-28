package com.nayak11.springboot.basics.springbootin10steps;

public class Book {
	
	long id;
	String name;
	String author;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Book(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	

}
