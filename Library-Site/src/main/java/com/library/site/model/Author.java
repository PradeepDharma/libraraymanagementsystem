package com.library.site.model;

import org.springframework.stereotype.Service;

@Service
public class Author {
	
	private String authorname;
	private String bookname;
	private String authorstatus;
	
	public Author() {
		
	}

	public Author(String authorname, String bookname, String authorstatus) {
		super();
		this.authorname = authorname;
		this.bookname = bookname;
		this.authorstatus = authorstatus;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorstatus() {
		return authorstatus;
	}

	public void setAuthorstatus(String authorstatus) {
		this.authorstatus = authorstatus;
	}
	
}
