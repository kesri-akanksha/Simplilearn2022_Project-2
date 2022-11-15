package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import com.java.DAO.TeacherDAOImpl;
import com.java.persistence.Teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addNewTeacher
 */
@WebServlet("/addNewTeacher")
public class addNewTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public addNewTeacher() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	
		String teacherName = request.getParameter("teacherName");
		
		Teacher teacher = new Teacher();
		

		teacher.setTeacherName(teacherName);
		try {
			PrintWriter pw = response.getWriter();

			int status = new TeacherDAOImpl().addTeacher(teacher);
			if(status>0){  
				pw.println("<h1>Teacher successfully added!</h1>");
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			}else{  
				pw.println("<h1>Sorry! unable to save record<h1>");  
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			} 
			} 
		catch (Exception e) {
			
			
			e.printStackTrace();
		}
		
		}
		
		
			
			}
			
		
		
	


