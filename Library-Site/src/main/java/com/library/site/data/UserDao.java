package com.library.site.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.site.model.User;

@Service
public class UserDao {

	@Autowired
	User user;
	
	public int addUser(String userid, String username, String password, String bookname, long contact) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "insert into user (User_ID,User_Name,Password,Book_Name,User_Contact) values ('" +userid+ "','" +username+ "','" +password+ "','" +bookname+ "','" +contact+ "')";
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return rowCount;
	}
		
	public List<User> searchUser(String userid) {
		List<User> userSearchList = new ArrayList<User>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = null;
			sqlQuery = "select User_Name, Book_Name, User_Contact from user where User_ID = '" +userid+ "'";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				user = new User();
				user.setUsername(rs.getString(1));
				user.setBookname(rs.getString(2));
				user.setContact(rs.getLong(3));
				userSearchList.add(user);
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return userSearchList;
	}
	
	public int updateUser(String userid, long contact) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "update user set User_Contact = '" + contact + "' where User_ID = '" +userid+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
	
	public int deleteUser(String userid) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "delete from user where User_ID = '" +userid+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
	
	public User checkActiveUser(String userid) {
		user = new User();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = null;
			sqlQuery = "select User_Name, Book_Name, Password, User_Contact from user where User_ID = '" +userid+ "'";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				user.setUserid(userid);
				user.setUsername(rs.getString(1));
				user.setBookname(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setContact(rs.getLong(4));
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		} 
		
		return user;
		
	}
	
}
