package com.library.site.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.library.site.data.BookDao;
import com.library.site.data.LendDao;
import com.library.site.data.UserDao;
import com.library.site.model.Book;
import com.library.site.model.User;

@Controller
@SessionAttributes("user")
public class BookAction {
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	LendDao lendDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	User user;
	
	@RequestMapping(value="/lendbook", method=RequestMethod.POST)
	public String lendBook(ModelMap model, @RequestParam String uid, @RequestParam String bookname) {
		int assignUserStatus = 0;
		int updateBookStatus = 0;
		user = userDao.checkActiveUser(uid);
		if(lendDao.checkBookStatus(bookname).equals("AVAILABLE")) {
			assignUserStatus = lendDao.assignBooktoUser(user.getUserid(), user.getUsername(), user.getPassword(), bookname , user.getContact());
			if(assignUserStatus > 0) {
				updateBookStatus = lendDao.updateBookStatus(bookname);
				if(updateBookStatus > 0) {
					model.put("bookstatus", "Book is successfully assigned to your ID");
				} else {
					model.put("bookstatus", "Issue with updating status of the book to NOT-AVAILABLE");
				}
			} else {
				model.put("bookstatus", "Issue with asigning the book to your ID");
			}
			return "requestbook";
		} else {
			model.put("bookstatus", "Book is not available for lending");
			return "requestbook";
		}
		
	}
	
	@RequestMapping(value="/usersearchbook", method=RequestMethod.POST)
	public String userviewBook(ModelMap model, @RequestParam String keyword, @RequestParam String searchtype) {
		List<Book> bookSearchList = new ArrayList<Book>();
		bookSearchList = bookDao.searchBook(keyword, searchtype);
		model.put("allbookdetails", bookSearchList);
		return "requestbook";
	}
	
	@RequestMapping(value="/viewbook", method=RequestMethod.POST)
	public String viewBook(ModelMap model, @RequestParam String keyword, @RequestParam String searchtype) {
		List<Book> bookSearchList = new ArrayList<Book>();
		bookSearchList = bookDao.searchBook(keyword, searchtype);
		model.put("bookdetails", bookSearchList);
		return "viewbook";
	}
	
	@RequestMapping(value="/viewbook", method=RequestMethod.GET)
	public String viewBook(ModelMap model) {
		return "viewbook";
	}
	
	@RequestMapping(value="/updatebook", method=RequestMethod.POST)
	public String updateBook(ModelMap model, @RequestParam String bookname, @RequestParam String bookstatus) {
		int rowReturned = 0;
		rowReturned = bookDao.updateBook(bookname, bookstatus);
		if(rowReturned > 0) {
			model.put("updateresult", "Book details have been updated sucessfully");
		} else {
			model.put("updateresult", "Issue with updating book details");
		}
		return "updatebook";
	}
	
	@RequestMapping(value="/updatebook", method=RequestMethod.GET)
	public String updateBookget(ModelMap model) {
		return "updatebook";
	}
	
	@RequestMapping(value="/deletebook", method=RequestMethod.POST)
	public String deleteBook(ModelMap model, @RequestParam String bookname) {
		int rowReturned = 0;
		rowReturned = bookDao.deleteBook(bookname);
		if(rowReturned > 0) {
			model.put("deleteresult", "Book details have been deleted sucessfully");
		} else {
			model.put("deleteresult", "Issue with deleting book details");
		}
		return "deletebook";
	}
	
	@RequestMapping(value="/deletebook", method=RequestMethod.GET)
	public String deleteBookget(ModelMap model) {
		return "deletebook";
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.POST)
	public String addBook(ModelMap model, @RequestParam String bookname, @RequestParam String bookcat, @RequestParam String bookauth, @RequestParam String bookpub, @RequestParam String bookstatus) {
		int rowReturned = 0;
		rowReturned = bookDao.addBook(bookname, bookcat, bookauth, bookpub, bookstatus);
		if(rowReturned > 0) {
			model.put("addresult", "Book details have been added sucessfully");
		} else {
			model.put("addresult", "Issue with adding book details");
		}
		return "addbook";
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.GET)
	public String addBook(ModelMap model) {
		System.out.println("add book get");
		return "addbook";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String showHome(ModelMap model) {
		return "home";
	}

}
