package com.java.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.SchoolClass;


import hibernateUtil.HibernateUtil;

public class ReportDAOImpl implements ReportDAO {

	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> generateReport(SchoolClass Class1) {
		List<Object> reportList=new ArrayList<Object>();
		
		
		
	
		try {
			sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();	
		
	
	Query q=sessionObj.createQuery("select subject_name,subject_id,class_id,teacher_id from learnersacademy where class_id=:i");
	q.setParameter("i",Class1);  
	reportList=(List<Object>) q.uniqueResult();
	
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
		return reportList;
	}
		
	

}
