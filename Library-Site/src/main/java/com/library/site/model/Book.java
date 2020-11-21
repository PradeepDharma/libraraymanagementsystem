package com.library.site.model;

import org.springframework.stereotype.Service;

@Service
public class Book {
	
	private String bookname;
	private String bookcat;
	private String bookauth;
	private String bookpub;
	private String bookstat;
	
	public Book() {
		
	}

	public Book(String bookname, String bookcat, String bookauth, String bookpub, String bookstat) {
		super();
		this.bookname = bookname;
		this.bookcat = bookcat;
		this.bookauth = bookauth;
		this.bookpub = bookpub;
		this.bookstat = bookstat;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookcat() {
		return bookcat;
	}

	public void setBookcat(String bookcat) {
		this.bookcat = bookcat;
	}

	public String getBookauth() {
		return bookauth;
	}

	public void setBookauth(String bookauth) {
		this.bookauth = bookauth;
	}

	public String getBookpub() {
		return bookpub;
	}

	public void setBookpub(String bookpub) {
		this.bookpub = bookpub;
	}

	public String getBookstat() {
		return bookstat;
	}

	public void setBookstat(String bookstat) {
		this.bookstat = bookstat;
	}
	
}
