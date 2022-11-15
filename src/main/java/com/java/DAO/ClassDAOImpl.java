package com.java.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.SchoolClass;

import hibernateUtil.HibernateUtil;


public class ClassDAOImpl implements ClassDAO {
	
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;

	//@SuppressWarnings("finally")
	
	@Override
	public int addClasses(SchoolClass Class1) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(Class1);
			sessionObj.getTransaction().commit();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
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
	public List<SchoolClass> getClasses() {
		return null;
	}

	
	@Override
	public SchoolClass getClasses(int classId) {
		SchoolClass Class1 = null;
		try {
			sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();	
		
	Class1 =  (SchoolClass) sessionObj.get(SchoolClass.class, classId);
		sessionObj.getTransaction().commit();
		
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();				
			}	
			ex.printStackTrace();
		}
		finally {
			sessionObj.close();			
		}
		return Class1;
	}

	
	@Override
	public void deleteClasses(int classId) {
	
		return;
	}


	
				
	
}
