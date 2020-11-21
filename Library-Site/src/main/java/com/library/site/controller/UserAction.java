package com.library.site.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.site.data.LendDao;
import com.library.site.data.UserDao;
import com.library.site.model.Book;
import com.library.site.model.User;

@Controller
public class UserAction {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	LendDao lendDao;
	
	@RequestMapping(value="/viewuser", method=RequestMethod.POST)
	public String viewuser(ModelMap model, @RequestParam String userid) {
		List<User> userSearchList = new ArrayList<User>();
		userSearchList = userDao.searchUser(userid);
		model.put("userdetails", userSearchList);
		return "viewuser";
	}
	
	@RequestMapping(value="/viewuser", method=RequestMethod.GET)
	public String viewuserGet(ModelMap model) {
		return "viewuser";
	}
	
	@RequestMapping(value="/updateuser", method=RequestMethod.POST)
	public String updateuser(ModelMap model, @RequestParam String userid, @RequestParam long contact) {
		int rowReturned = 0;
		rowReturned = userDao.updateUser(userid, contact);
		if(rowReturned > 0) {
			model.put("updateresult", "User details have been updated sucessfully");
		} else {
			model.put("updateresult", "Issue with updating user details");
		}
		return "updateuser";
	}
	
	@RequestMapping(value="/updateuser", method=RequestMethod.GET)
	public String updateuserGet(ModelMap model) {
		return "updateuser";
	}
	
	@RequestMapping(value="/deleteuser", method=RequestMethod.POST)
	public String deleteuser(ModelMap model, @RequestParam String userid) {
		int rowReturned = 0;
		rowReturned = userDao.deleteUser(userid);
		if(rowReturned > 0) {
			model.put("deleteresult", "User details have been deleted sucessfully");
		} else {
			model.put("deleteresult", "Issue with deleting user details");
		}
		return "deleteuser";
	}
	
	@RequestMapping(value="/deleteuser", method=RequestMethod.GET)
	public String deleteuserGet(ModelMap model) {
		return "deleteuser";
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public String adduser(ModelMap model, @RequestParam String userid, @RequestParam String username, @RequestParam String password, @RequestParam String bookname, @RequestParam long contact) {
		int rowReturned = 0;
		rowReturned = userDao.addUser(userid, username, password, bookname, contact);
		if(rowReturned > 0) {
			model.put("addresult", "User details have been added sucessfully");
		} else {
			model.put("addresult", "Issue with added user details");
		}
		return "adduser";
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public String adduserGet(ModelMap model) {
		return "adduser";
	}
	
	@RequestMapping(value="/allbook", method=RequestMethod.POST)
	public String allBooks(ModelMap model) {
		List<Book> allBookList = new ArrayList<Book>();
		allBookList = lendDao.retrieveallBooks();
		model.put("allbookdetails", allBookList);
		return "requestbook";
	}
	
	@RequestMapping(value="/availbook", method=RequestMethod.POST)
	public String availBooks(ModelMap model) {
		List<Book> availBookList = new ArrayList<Book>();
		availBookList = lendDao.retrieveavailBooks();
		model.put("allbookdetails", availBookList);
		return "requestbook";
	}

}
