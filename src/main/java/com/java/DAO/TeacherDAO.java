package com.java.DAO;

import java.util.List;

import com.java.persistence.Teacher;

public interface TeacherDAO {

	public int addTeacher(Teacher teacher);
	 
	 public List<Teacher> getTeacher();
	 
	 public  Teacher getTeacher(int teacherId);
	 
	 public void deleteTeacher(int teacherId);
	 
	
}
