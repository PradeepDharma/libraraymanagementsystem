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
import com.library.site.model.Publisher;

@Service
public class PublisherDao {
	
	@Autowired
	Publisher publisher;
	
	@Autowired
	Book book;
	
	public int addPublisher(String publishername, String bookname, String publisherstatus) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "insert into publisher (Publisher_Name,Book_Name,Publisher_Status) values ('" +publishername+ "','" +bookname+ "','" +publisherstatus+ "')";
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return rowCount;
	}
		
	public List<Book> searchPublisher(String publishername) {
		List<Book> publisherSearchList = new ArrayList<Book>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "select Book_Name, Book_Category, Book_Author, Book_Status from book where Publisher_Name = '" +publishername+ "'";
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				book = new Book();
				book.setBookname(rs.getString(1));
				book.setBookcat(rs.getString(2));
				book.setBookauth(rs.getString(3));
				book.setBookstat(rs.getString(4));
				publisherSearchList.add(book);
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return publisherSearchList;
	}
	
	public String publisherStatus(String publishername) {
		ResultSet rs = null;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "select Publisher_Status from publisher where Publisher_Name = '" +publishername+ "'";
			rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  {
				publisher = new Publisher();
				publisher.setPublisherstatus(rs.getString(1));
			}
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}  
		return publisher.getPublisherstatus();
	}
	
	public int updatePublisher(String publishername, String publisherstatus) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "update publisher set Publisher_Status = '" + publisherstatus + "' where Publisher_Name = '" +publishername+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}
	
	public int deletePublisher(String publishername) {
		int rowCount = 0;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem","root","");  
			Statement stmt=con.createStatement();  
			String sqlQuery = "delete from publisher where Publisher_Name = '" +publishername+ "'"; 
			rowCount = stmt.executeUpdate(sqlQuery);
			con.close();  
		} catch(Exception e) { 
			System.out.println(e);
		}
		return rowCount;
	}

}
