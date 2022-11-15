package com.java.DAO;

import java.util.List;


import com.java.persistence.SchoolClass;


public interface ClassDAO {
	
	public int addClasses(SchoolClass Class1);  //to add a class
	 
	 public List<SchoolClass> getClasses();    // to get the list of class
	 
	 public SchoolClass getClasses(int classId);    //to get a single class
	 
	 public void deleteClasses(int classId);   //to delete a class

}
