package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LopHocDAO;
import com.dao.StudentDAO;
import com.model.LopHoc;
import com.model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet(name = "Student", urlPatterns = { "/student/*" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
	private LopHocDAO lopHocDAO;

	public void init() {
		studentDAO = new StudentDAO();
		lopHocDAO = new LopHocDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String action = getAction(uri);
		switch (action) {
		case "/student/save":
			saveStudent(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void saveStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// save the customer using our service
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		int lophocid = Integer.parseInt(request.getParameter("id"));
		Student student = new Student(firstname, lastname, age);
		studentDAO.saveStudent(student, lophocid);

	}

	

	private String getAction(String uri) {
		String[] temp = uri.split("student");
		return "/student".concat(temp[temp.length - 1]);
	}
}
