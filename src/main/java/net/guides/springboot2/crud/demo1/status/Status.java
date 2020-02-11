package net.guides.springboot2.crud.demo1.status;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.guides.springboot2.crud.demo1.controller.ReportController;

//import org.springframework.scheduling.annotation.Scheduled;

//import net.guides.springboot2.crud.model.Report;

public class Status {
	 
	private static final Logger logg=LoggerFactory.getLogger(Status.class); 
	
	public String StatusGenerator(int doctorid) {
		
	  
	  List<Integer> list = new ArrayList<Integer>();
	  
	  list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
	  // Report report = new Report(); //for ( i = 1; i < 5; i++) 
	  
	  { String
	  str=null; 
	  
	  if( list.contains(doctorid)) {
	  
	  str="approved";
				/* String value= String.valueOf(); */
		
	  }
	  
	  else {
	  
	  str="processing";
	  
	  }
	  logg.info(str);
	  return str; }
	 
}}
