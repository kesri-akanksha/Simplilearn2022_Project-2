package com.java.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.java.persistence.Student;

import hibernateUtil.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {
	
	 SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	 Session sessionObj;


	@Override
	public int addStudent(Student student) {
		
			try {
				sessionObj = sessionFactoryObj.openSession();
				sessionObj.getTransaction().begin();
				sessionObj.saveOrUpdate(student);
				sessionObj.getTransaction().commit();
			}
			catch(Exception ex) {
				if(sessionObj.getTransaction() != null) {
					sessionObj.getTransaction().rollback();
				}
				ex.printStackTrace();
				return 0;
			}
			finally {
				sessionObj.close();
			}
			
			return 1;
			
	}

	
	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(int studentId) {
		Student student = null;
		try {
			sessionObj = sessionFactoryObj.openSession();
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();	
		
		Student student1 =  (Student) sessionObj.get(Student.class, studentId);
		sessionObj.getTransaction().commit();
		
		}
		finally {
			sessionObj.close();
		}
		return student;
	}

	

	@Override
	public void deleteStudent(int studentId) {
		
		try {
			sessionObj = sessionFactoryObj.openSession();
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();
		Student student =  (Student) sessionObj.get(Student.class, studentId);
		sessionObj.delete(studentId);
        sessionObj.getTransaction().commit();
		
		}
		finally {
			sessionObj.close();
		}
		
	
		
	}

}

