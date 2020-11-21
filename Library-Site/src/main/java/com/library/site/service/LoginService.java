package com.library.site.service;

import org.springframework.stereotype.Service;

import com.library.site.model.User;

@Service
public class LoginService {
	
	public String validateUser(String username, String password) {
		
		String userType = null;
		
		if(username.equals("admin") && password.equals("admin")) {
			userType = "admin";
		} else {
			userType = "user";
		}
		return userType;
		
	}
	
	public Boolean validateUserFromDB(User user, String uid, String password) {
			
			if(uid.equals(user.getUserid()) && password.equals(user.getPassword())) {
				return true;
			}
			
			return false;
			
		}

}
