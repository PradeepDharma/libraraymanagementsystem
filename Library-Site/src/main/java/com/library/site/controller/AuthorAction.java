package com.library.site.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.site.data.AuthorDao;
import com.library.site.model.Book;

@Controller
public class AuthorAction {
	
	@Autowired
	AuthorDao authorDao;
	
	@RequestMapping(value="/viewauthor", method=RequestMethod.POST)
	public String viewauthor(ModelMap model, @RequestParam String authorname) {
		List<Book> authorSearchList = new ArrayList<Book>();
		authorSearchList = authorDao.searchAuthor(authorname);
		model.put("authordetails", authorSearchList);
		model.put("authorstatus", authorDao.authorStatus(authorname));
		return "viewauthor";
	}
	
	@RequestMapping(value="/viewauthor", method=RequestMethod.GET)
	public String viewauthorGet(ModelMap model) {
		return "viewauthor";
	}
	
	@RequestMapping(value="/updateauthor", method=RequestMethod.POST)
	public String updateauthor(ModelMap model, @RequestParam String authorname, @RequestParam String authorstatus) {
		int returnedRow = 0;
		returnedRow = authorDao.updateAuthor(authorname, authorstatus);
		if(returnedRow > 0) {
			model.put("updateresult", "Author details have been updated successfully");
		} else {
			model.put("updateresult", "Issue with updating author details");
		}
		return "updateauthor";
	}
	
	@RequestMapping(value="/updateauthor", method=RequestMethod.GET)
	public String updateauthorGet(ModelMap model) {
		return "updateauthor";
	}
	
	@RequestMapping(value="/deleteauthor", method=RequestMethod.POST)
	public String deleteauthor(ModelMap model, @RequestParam String authorname) {
		int returnedRow = 0;
		returnedRow = authorDao.deleteAuthor(authorname);
		if(returnedRow > 0) {
			model.put("deleteresult", "Author details have been deleted successfully");
		} else {
			model.put("deleteresult", "Issue with deleting author details");
		}
		return "deleteauthor";
	}
	
	@RequestMapping(value="/deleteauthor", method=RequestMethod.GET)
	public String deleteauthorGet(ModelMap model) {
		return "deleteauthor";
	}
	
	@RequestMapping(value="/addauthor", method=RequestMethod.POST)
	public String addauthor(ModelMap model, @RequestParam String authorname, @RequestParam String bookname, @RequestParam String authorstatus) {
		int returnedRow = 0;
		returnedRow = authorDao.addAuthor(authorname, bookname, authorstatus);
		if(returnedRow > 0) {
			model.put("addresult", "Author details have been added successfully");
		} else {
			model.put("addresult", "Issue with adding author details");
		}
		return "addauthor";
	}
	
	@RequestMapping(value="/addauthor", method=RequestMethod.GET)
	public String addauthorGet(ModelMap model) {
		return "addauthor";
	}

}
