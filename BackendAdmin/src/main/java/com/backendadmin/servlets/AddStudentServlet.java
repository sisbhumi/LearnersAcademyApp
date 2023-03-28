package com.backendadmin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.backendadmin.utils.StudentdataUtil;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement preparedstatement;
	@Resource(name = "jdbc/schooladmin")
	private DataSource datasource;

	private StudentdataUtil studentUtil;

	public void init(ServletConfig config) throws ServletException {

		try {

			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			studentUtil = new StudentdataUtil(datasource);
			preparedstatement = con.prepareStatement("insert into student values (?,?,?)");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("stu_name");
		String email = request.getParameter("stu_email");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		if (!isValidInput(name, false) || !isValidInput(email, false)) {
			out.println("Please enter valid input.");
			return;
		}

		try {
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, email);
			preparedstatement.setString(3, id);
			
			int result = preparedstatement.executeUpdate();
			out.println("Product Created. result = " + result);
		} catch (SQLException e) {
			out.println("Product not created. Error Occured. " + e.getMessage());
			e.printStackTrace();
		}

		studentUtil.getStudents();
		request.setAttribute("student_list", studentUtil.getStudents());

		RequestDispatcher d = request.getRequestDispatcher("/showstudent.jsp");
		d.forward(request, response);
	}

	private boolean isValidInput(String inputValue, boolean isNumber) {
		if (inputValue == null || inputValue.isBlank() || inputValue.isEmpty()) {
			return false;
		} else if (isNumber) {
			Integer.parseInt(inputValue);
			return true;
		} else {
			return true;
		}
	}

	public void destroy() {
		try {
			if (con != null)
				con.close();
			if (preparedstatement != null)
				preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
