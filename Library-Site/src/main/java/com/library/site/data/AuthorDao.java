package com.library.site.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.site.model.Author;
import com.library.site.model.Book;

@Service
public class AuthorDao {
	
	@Autowired
	Author author;
	
	@Autowired
	Book book;
	
	public int addAuthor(String authorname, String bookname, String authorstatus) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "insert into author (Author_Name,Book_Name,Author_Status) values ('" +authorname+ "','" +bookname+ "','" +authorstatus+ "')";
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		} 
		return rowCount;
	}
		
	public List<Book> searchAuthor(String authorname) {
		List<Book> authorSearchList = new ArrayList<Book>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "select Book_Name, Book_Category, Publisher_Name, Book_Status from book where Book_Author = '" +authorname+ "'";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				book = new Book();
				book.setBookname(rs.getString(1));
				book.setBookcat(rs.getString(2));
				book.setBookpub(rs.getString(3));
				book.setBookstat(rs.getString(4));
				authorSearchList.add(book);
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return authorSearchList;
	}
	
	public String authorStatus(String authorname) {
		ResultSet rs = null;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "select Author_Status from author where Author_Name = '" +authorname+ "'";
			rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				author = new Author();
				author.setAuthorstatus(rs.getString(1));
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return author.getAuthorstatus();
	}
	
	public int updateAuthor(String authorname, String authorstatus) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "update author set Author_Status = '" + authorstatus + "' where Author_Name = '" +authorname+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
	
	public int deleteAuthor(String authorname) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "delete from author where Author_Name = '" +authorname+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}

}
