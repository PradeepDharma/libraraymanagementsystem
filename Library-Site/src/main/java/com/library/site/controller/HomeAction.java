package com.library.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeAction {
	
	@RequestMapping(value="/book", method=RequestMethod.POST)
	public String showBook(ModelMap model) {
		return "book";
	}
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public String showBookGet(ModelMap model) {
		return "book";
	}
	
	@RequestMapping(value="/author", method=RequestMethod.POST)
	public String showAuthor(ModelMap model) {
		return "author";
	}
	
	@RequestMapping(value="/author", method=RequestMethod.GET)
	public String showAuthorGet(ModelMap model) {
		return "author";
	}
	
	@RequestMapping(value="/publisher", method=RequestMethod.POST)
	public String showPublisher(ModelMap model) {
		return "publisher";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String showUser(ModelMap model) {
		return "user";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logOut(ModelMap model) {
		return "login";
	}
	
}
