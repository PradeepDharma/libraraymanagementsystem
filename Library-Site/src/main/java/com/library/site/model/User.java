package com.library.site.model;

import org.springframework.stereotype.Service;

@Service
public class User {
	
	private String userid;
	private String username;
	private String bookname;
	private String password;
	private long contact;
	
	public User() {
		
	}

	public User(String userid, String username, String bookname, String password, long contact) {
		super();
		this.userid = userid;
		this.username = username;
		this.bookname = bookname;
		this.password = password;
		this.contact = contact;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
}
