package com.java.DAO;

import java.util.List;


import com.java.persistence.Student;

public interface StudentDAO {
	
public int addStudent(Student student);
	
	public List<Student> getStudent();
	
	public Student getStudent(int studentId);
	
	public void deleteStudent(int studentId);
	
	


}
