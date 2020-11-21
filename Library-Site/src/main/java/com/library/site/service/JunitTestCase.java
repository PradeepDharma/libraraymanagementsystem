package com.library.site.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.library.site.data.AuthorDao;
import com.library.site.data.BookDao;
import com.library.site.data.LendDao;
import com.library.site.data.PublisherDao;
import com.library.site.data.UserDao;


public class JunitTestCase {  
  
	AuthorDao authorDao;
	BookDao bookDao;
	LendDao lendDao;
	PublisherDao publisherDao;
	UserDao userDao;
	LoginService loginService;
	
	
    @Before  
    public void setUp() throws Exception {  
        this.authorDao = new AuthorDao();
        this.bookDao = new BookDao();
        this.lendDao = new LendDao();
        this.publisherDao = new PublisherDao();
        this.userDao = new UserDao();
        this.loginService = new LoginService();
    } 
    
    //LoginService
    @Test
    public void validateUser(){
    	assertNotNull(loginService.validateUser("test", "test"));
    }
    
    //Publisher
    @Test
    public void addPublisher(){
    	assertNotNull(publisherDao.addPublisher("test", "test", "test"));
    }
    
    @Test
    public void deletePublisher(){
    	assertNotNull(publisherDao.deletePublisher("test"));
    }
    
    @Test
    public void searchPublisher(){
    	assertNotNull(publisherDao.searchPublisher("test"));
    }
    
    @Test
    public void updatePublisher(){
    	assertNotNull(publisherDao.updatePublisher("test", "test"));
    }
    
    //Lend
    @Test  
    public void assignBooktoUser(){
    	assertNotNull(lendDao.assignBooktoUser("test", "test", "test", "test", 123));
    }
    
    @Test  
    public void checkBookStatus(){
    	assertNotNull(lendDao.checkBookStatus("test"));
    }
    
    @Test  
    public void retrieveallBooks(){
    	assertNotNull(lendDao.retrieveallBooks());
    }
    
    @Test  
    public void retrieveavailBooks(){
    	assertNotNull(lendDao.retrieveavailBooks());
    }
    
    @Test  
    public void updateBookStatus(){
    	assertNotNull(lendDao.updateBookStatus("test"));
    }
    
    //Book
    @Test  
    public void addBook(){
    	assertNotNull(bookDao.addBook("test", "test", "test", "test", "test"));
    }
    
    @Test  
    public void deleteBook(){
    	assertNotNull(bookDao.deleteBook("test"));
    }
    
    @Test  
    public void searchBook(){
    	assertNotNull(bookDao.searchBook("test", "test"));
    }
    
    @Test  
    public void updateBook(){
    	assertNotNull(bookDao.updateBook("test", "test"));
    }
    

    //Author
    @Test  
    public void checkAddAuthor(){
    	assertNotNull(authorDao.addAuthor("test", "test", "test"));
    }
    
    @Test
    public void checkauthorStatus(){
    	assertNotNull(authorDao.authorStatus("test"));
    }
    
    @Test 
	public void checkdeleteAuthor(){
		assertNotNull(authorDao.deleteAuthor("test"));
	}
    
    @Test 
	public void checksearchAuthor(){
		assertNotNull(authorDao.searchAuthor("test"));
	}
	
	@Test 
	public void updateAuthor(){
		assertNotNull(authorDao.updateAuthor("test", "test"));
	}
	
	
	//User
	@Test 
	public void checkActiveUser(){
		assertNotNull(userDao.checkActiveUser("A01"));
	}
	
	@Test 
	public void addUser(){
		assertNotNull(userDao.addUser("test", "test", "test", "test", 123));
	}
	
	@Test 
	public void deleteUser(){
		assertNotNull(userDao.deleteUser("A01"));
	}
	
	@Test 
	public void searchUser(){
		assertNotNull(userDao.searchUser("A01"));
	}
	
	@Test 
	public void updateUser(){
		assertNotNull(userDao.updateUser("test", 123));
	}
	
} 

