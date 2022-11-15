package com.java.DAO;


import java.util.List;

import com.java.persistence.Student;
import com.java.persistence.Subject;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateUtil.HibernateUtil;

public class SubjectDAOImpl implements SubjectDAO {

	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;
	
	@SuppressWarnings("finally")
	@Override
	public int addSubject(Subject subject) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(subject);
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
	public List<Subject> getSubject() {
	return null;
			
	}

	@Override
	public Subject getSubject(int subjectId) {
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();	
		
		Subject subject =  (Subject) sessionObj.get(Subject.class, subjectId);
		sessionObj.getTransaction().commit();
		return subject;
	}

	@Override
	public void deleteSubject(int subjectId) {
		try {
			sessionObj = sessionFactoryObj.openSession();
		sessionObj = sessionFactoryObj.getCurrentSession();
		sessionObj.getTransaction().begin();
		Subject subject =  (Subject) sessionObj.get(Student.class, subjectId);
		sessionObj.delete(subjectId);
        sessionObj.getTransaction().commit();
		
		}
		finally {
			sessionObj.close();
		}
		
	
	}

	
}
