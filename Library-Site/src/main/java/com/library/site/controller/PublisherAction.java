package com.library.site.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.site.data.PublisherDao;
import com.library.site.model.Book;

@Controller
public class PublisherAction {
	
	@Autowired
	PublisherDao publisherDao;
	
	@RequestMapping(value="/viewpublisher", method=RequestMethod.POST)
	public String viewpublisher(ModelMap model, @RequestParam String publishername) {
		List<Book> publisherSearchList = new ArrayList<Book>();
		publisherSearchList = publisherDao.searchPublisher(publishername);
		model.put("publisherdetails", publisherSearchList);
		model.put("publisherstatus", publisherDao.publisherStatus(publishername));
		return "viewpublisher";
	}
	
	@RequestMapping(value="/viewpublisher", method=RequestMethod.GET)
	public String viewpublisherGet(ModelMap model) {
		return "viewpublisher";
	}
	
	@RequestMapping(value="/updatepublisher", method=RequestMethod.POST)
	public String updatepublisher(ModelMap model, @RequestParam String publishername, @RequestParam String publisherstatus) {
		int returnedRow = 0;
		returnedRow = publisherDao.updatePublisher(publishername, publisherstatus);
		if(returnedRow > 0) {
			model.put("updateresult", "Publisher details have been updated successfully");
		} else {
			model.put("updateresult", "Issue with updating publisher details");
		}
		return "updatepublisher";
	}
	
	@RequestMapping(value="/updatepublisher", method=RequestMethod.GET)
	public String updatepublisherGet(ModelMap model) {
		return "updatepublisher";
	}
	
	@RequestMapping(value="/deletepublisher", method=RequestMethod.POST)
	public String deletepublisher(ModelMap model, @RequestParam String publishername) {
		int returnedRow = 0;
		returnedRow = publisherDao.deletePublisher(publishername);
		if(returnedRow > 0) {
			model.put("deleteresult", "Publisher details have been deleted successfully");
		} else {
			model.put("deleteresult", "Issue with deleting publisher details");
		}
		return "deletepublisher";
	}
	
	@RequestMapping(value="/deletepublisher", method=RequestMethod.GET)
	public String deletepublisherGet(ModelMap model) {
		return "deletepublisher";
	}
	
	@RequestMapping(value="/addpublisher", method=RequestMethod.POST)
	public String addpublisher(ModelMap model, @RequestParam String publishername, @RequestParam String bookname, @RequestParam String publisherstatus) {
		int returnedRow = 0;
		returnedRow = publisherDao.addPublisher(publishername, bookname, publisherstatus);
		if(returnedRow > 0) {
			model.put("addresult", "Publisher details have been added successfully");
		} else {
			model.put("addresult", "Issue with adding publisher details");
		}
		return "addpublisher";
	}
	
	@RequestMapping(value="/addpublisher", method=RequestMethod.GET)
	public String addpublisherGet(ModelMap model) {
		return "addpublisher";
	}

}
