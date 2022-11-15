package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.java.DAO.ClassDAOImpl;
import com.java.DAO.StudentDAOImpl;
import com.java.persistence.SchoolClass;
import com.java.persistence.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addNewStudent
 */
@WebServlet("/addNewStudent")
public class addNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewStudent() {
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
		response.setContentType("Text/html");

		String studentName = request.getParameter("studentName");
		int classId = Integer.valueOf(request.getParameter("classes"));
		

		Student student = new Student();
		SchoolClass Class1= new ClassDAOImpl().getClasses(classId);
		
		student.setStudentName(studentName);		
		student.setClasses(Class1);

		try {
			int status = new StudentDAOImpl().addStudent(student);
			if(status>0){  
				pw.println("<h1>Student successfully registered!</h1>");
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			}else{  
				pw.println("<h1>Sorry! unable to save record<h1>");  
				request.getRequestDispatcher("index1.jsp").include(request, response);  
			} 

		} catch (Exception e) {
		
			pw.println("<h1>SQL Exception</h1>");
			e.printStackTrace();
		}

	}
}
