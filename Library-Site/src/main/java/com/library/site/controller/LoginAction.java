package com.library.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.library.site.data.UserDao;
import com.library.site.model.User;
import com.library.site.service.LoginService;

@Controller
@SessionAttributes("uid")
public class LoginAction {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	User user;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String uid, @RequestParam String password) {
		String userType = null;
		userType = loginService.validateUser(uid, password);
		if(userType.equals("admin")) {
			return "home";
		} else {
			user = userDao.checkActiveUser(uid);
			if(loginService.validateUserFromDB(user, uid, password)) {
				return "requestbook";
			} else {
				model.put("errormessage", "Invalid Credential");
				return "login";
			}
			
		}
		
	}
}
