package com.library.site.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.site.model.Book;

@Service
public class LendDao {
	
	@Autowired
	Book book;
	
	public List<Book> retrieveallBooks() {
		List<Book> allBookList = new ArrayList<Book>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = null;
			sqlQuery = "select * from book";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				book = new Book();
				book.setBookname(rs.getString(1));
				book.setBookcat(rs.getString(2));
				book.setBookauth(rs.getString(3));
				book.setBookpub(rs.getString(4));
				book.setBookstat(rs.getString(5));
				allBookList.add(book);
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		} 
		return allBookList;
	}
	
	public List<Book> retrieveavailBooks() {
		List<Book> availBookList = new ArrayList<Book>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = null;
			sqlQuery = "select * from book where Book_Status = 'AVAILABLE'";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				book = new Book();
				book.setBookname(rs.getString(1));
				book.setBookcat(rs.getString(2));
				book.setBookauth(rs.getString(3));
				book.setBookpub(rs.getString(4));
				book.setBookstat(rs.getString(5));
				availBookList.add(book);
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		} 
		return availBookList;
	}
	
	public String checkBookStatus(String bookname) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = null;
			sqlQuery = "select Book_Status from book where Book_Name = '" +bookname+"'";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				book = new Book();
				book.setBookstat(rs.getString(1));
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		} 
		return book.getBookstat();
	}
	
	public int assignBooktoUser(String userid, String username, String password, String bookname, long contact) {
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
	
	public int updateBookStatus(String bookname) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "update book set Book_Status = 'NOT-AVAILABLE' where Book_Name = '" +bookname+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
	

}
