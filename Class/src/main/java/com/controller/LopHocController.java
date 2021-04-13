package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LopHocDAO;
import com.model.LopHoc;
import com.model.Student;

@WebServlet(name = "Lophoc", urlPatterns = { "/lophoc/*" })
public class LopHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LopHocDAO lopHocDAO;

	public void init() {
		lopHocDAO = new LopHocDAO();
	}

	public LopHocController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/save":
			saveLopHoc(request, response);
			break;
		case "/add":
			showFormForAdd(request, response);
			break;
		case "/home":
			listLopHoc(request, response);
			break;
		case "/addStudent":
			showFormForAddStudent(request, response);
			break;

		case "/viewStudentClass":
			showFormViewStudentClass(request, response);
			break;
		}
		

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	public void saveLopHoc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// save the customer using our service
		String tenLop = request.getParameter("tenLop");
		int id = Integer.parseInt(request.getParameter("id"));
		List<Student> studentList = lopHocDAO.getStudents(id);
		LopHoc lophoc = new LopHoc(tenLop, studentList);
		lopHocDAO.saveLopHoc(lophoc);

		response.sendRedirect("home");
	}
	
	public void showFormForAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("id",id);
		request.getRequestDispatcher("/WEB-INF/view/lophoc-form.jsp").forward(request, response);
	}
	public void showFormForAddStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		request.setAttribute("id",id);
		request.getRequestDispatcher("/WEB-INF/view/student-form.jsp").forward(request, response);
	}
	public void listLopHoc(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// get persons from the service
		List<LopHoc> lopHocs = lopHocDAO.getLopHoc();
		// add the customers to the model
		request.setAttribute("lophoc", lopHocs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/lophoc-list.jsp");
		dispatcher.forward(request, response);
	}
	public void showFormViewStudentClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int lophocid = Integer.parseInt(request.getParameter("id"));
		LopHoc lopHoc = lopHocDAO.getLopHoc(lophocid);
		request.setAttribute("lophoc", lopHoc);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student-list.jsp");
		dispatcher.forward(request, response);
	}

//	private String getAction(String uri) {
//		String[] temp = uri.split("lophoc");
//		return "/lophoc".concat(temp[temp.length - 1]);
//	}
}
