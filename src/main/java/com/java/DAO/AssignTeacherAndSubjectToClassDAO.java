package com.java.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistence.SchoolClass;
import com.java.persistence.Subject;
import com.java.persistence.Teacher;
import org.hibernate.Query;

import hibernateUtil.HibernateUtil;

public class AssignTeacherAndSubjectToClassDAO {
	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	Session sessionObj;


	public int addTeacherAndSubjectToClass(SchoolClass Class1, int teacherId, int subjectId) {
		try {	
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			Teacher teacher= new Teacher();
			teacher = new TeacherDAOImpl().getTeacher(teacherId);
			
			System.out.println(teacher.getTeacherId());
			
			Subject subject = new Subject();
			subject = new SubjectDAOImpl().getSubject(subjectId);

			Class1.getTeachers().add(teacher);
			Class1.getSubjects().add(subject);
			
			Query q=sessionObj.createQuery("from Teacher where teacher_id=:i");  
			
			
			return 1;
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				ex.printStackTrace();
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
				return 0;
			}
		}		
		finally {			
			sessionObj.close();
			
		}
		return 1;
	}
}
