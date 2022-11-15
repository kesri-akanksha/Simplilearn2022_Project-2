package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.java.DAO.ClassDAOImpl;

import com.java.persistence.SchoolClass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addNewClass
 */
@WebServlet("/addNewClass")
public class addNewClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int status = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewClass() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String className = request.getParameter("className");
		
		SchoolClass Class1 = new SchoolClass();
		Class1.setClassName(className);
		try {
			 PrintWriter pw = response.getWriter();
			int status = new ClassDAOImpl().addClasses(Class1);
			if(status>0){  
				pw.println("<h1>Class successfully added!</h1>");
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			}
			
			else{  
				pw.println("<h1>Sorry! unable to save record<h1>");  
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			} 

		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		}
	
	
}
	

