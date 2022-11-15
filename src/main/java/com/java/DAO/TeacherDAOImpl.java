package com.java.DAO;

import java.util.List;

import com.java.persistence.Student;
import com.java.persistence.Teacher;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateUtil.HibernateUtil;

public  class TeacherDAOImpl implements TeacherDAO{

	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;
	
	@SuppressWarnings("finally")
	@Override
	public int addTeacher(Teacher teacher) {
	
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(teacher);
			sessionObj.getTransaction().commit();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
				return 0;
			}
		}
		finally {
			sessionObj.close();
			return 1;
		}
	}

		@Override
	public List<Teacher> getTeacher() {
	
		return null;
	}

	@Override
	public Teacher getTeacher(int teacherId) {
		
		Teacher list = null;
		try {
		sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();	
		Query q=sessionObj.createQuery("from Teacher where teacher_id=:i");  
		q.setParameter("i",teacherId);  
		list=(Teacher) q.uniqueResult();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();				
			}				
		}
		finally {
			sessionObj.close();	
		}
		return list;
		}
	
	
	@Override
	public void deleteTeacher(int teacherId) {
		
		try {
			sessionObj = sessionFactoryObj.openSession();
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();
		Teacher teacher1 =  (Teacher) sessionObj.get(Student.class, teacherId);
		sessionObj.delete(teacherId);
        sessionObj.getTransaction().commit();
		
		}
		finally {
			sessionObj.close();
		}
		
	
		
	}

	
}
