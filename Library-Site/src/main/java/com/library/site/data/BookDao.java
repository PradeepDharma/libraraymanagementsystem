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
public class BookDao {
	
	@Autowired
	Book book;
	
	public int addBook(String bookname, String bookcat, String bookauth, String bookpub, String bookstatus) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "insert into book (Book_Name,Book_Category,Book_Author,Publisher_Name,Book_Status) values ('" +bookname+ "','" +bookcat+ "','" +bookauth+ "','" +bookpub+ "','" +bookstatus+ "')";
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return rowCount;
	}
		
	public List<Book> searchBook(String keyword, String searchtype) {
		List<Book> bookSearchList = new ArrayList<Book>();
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = null;
			if(searchtype.equals("bookname")) {
				sqlQuery = "select * from book where Book_Name = '" +keyword+ "'";
			} if(searchtype.equals("bookcategory")) {
				sqlQuery = "select * from book where Book_Category = '" +keyword+ "'";
			} if(searchtype.equals("authorname")) {
				sqlQuery = "select * from book where Book_Author = '" +keyword+ "'";
			} if(searchtype.equals("publishername")) {
				sqlQuery = "select * from book where Publisher_Name = '" +keyword+ "'";
			}
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				book = new Book();
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3) + " " +rs.getString(4));
				book.setBookname(rs.getString(1));
				book.setBookcat(rs.getString(2));
				book.setBookauth(rs.getString(3));
				book.setBookpub(rs.getString(4));
				book.setBookstat(rs.getString(5));
				bookSearchList.add(book);
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return bookSearchList;
	}
	
	public int updateBook(String bookname, String bookstatus) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "update book set Book_Status = '" + bookstatus + "' where Book_Name = '" +bookname+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
	
	public int deleteBook(String bookname) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "delete from book where Book_Name = '" +bookname+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
}
