package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.java.DAO.AssignTeacherToClassDAO;
import com.java.DAO.ClassDAOImpl;

import com.java.persistence.SchoolClass;



/**
 * Servlet implementation class AssignTeacherToClass
 */
@WebServlet("/AssignTeacherToClass")
public class AssignTeacherToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherToClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		int teacherId = Integer.valueOf(request.getParameter("teachers"));
		int classId = Integer.valueOf(request.getParameter("classes"));
		
		SchoolClass class1= new SchoolClass();
		//Teacher teacher = new TeacherDAOImpl().getTeacher(teacherId);				
		class1 = new ClassDAOImpl().getClasses(classId);		
		 System.out.println(class1.getClassId());
		//Class.getTeachers().add(teacher);		

		try {
			int status  = new AssignTeacherToClassDAO().addTeacherToClass(class1, teacherId);
			if(status>0){  
				pw.println("<h1>Teacher AssignedTo Class successfully!</h1>");
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			}else{  
				pw.println("<h1>Sorry! unable to save record<h1>");  
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			} 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			pw.println("<h1>SQL Exception</h1>");
			e.printStackTrace();
		}
	}

	}


