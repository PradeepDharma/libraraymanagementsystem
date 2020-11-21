package com.library.site.model;

import org.springframework.stereotype.Service;

@Service
public class Publisher {

	private String publishername;
	private String bookname;
	private String publisherstatus;
	
	public Publisher() {
		
	}

	public Publisher(String publishername, String bookname, String publisherstatus) {
		super();
		this.publishername = publishername;
		this.bookname = bookname;
		this.publisherstatus = publisherstatus;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisherstatus() {
		return publisherstatus;
	}

	public void setPublisherstatus(String publisherstatus) {
		this.publisherstatus = publisherstatus;
	}
	
	
}
