package com.backendadmin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.backendadmin.domain.Standard;
import com.backendadmin.domain.Student;
import com.backendadmin.domain.Teacher;
import com.backendadmin.utils.HibernateUtil;
import com.backendadmin.utils.StudentdataUtil;
import com.backendadmin.utils.SubjectUtil;
import com.backendadmin.utils.TeacherUtil;

@WebServlet("/addTeacher") 
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Teacher teacher;
	private Connection con;
	private PreparedStatement preparedstatement;
	@Resource(name = "jdbc/schooladmin")
	private DataSource datasource;
	private TeacherUtil teacherUtil;
	
	public void init(ServletConfig config) throws ServletException {
		
		try {
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedstatement = con.prepareStatement("insert into teahcer (teahcer_name,teacher_email) values (?,?)");
			teacherUtil = new TeacherUtil(datasource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("teacher_name");
		String email = request.getParameter("teacher_email");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		if (!isValidInput(name, false) || !isValidInput(email, false)) {
			out.println("Please enter valid input.");
			return;
		}

		try {
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, email);
			
			int result = preparedstatement.executeUpdate();
			out.println("Product Created. result = " + result);
		} catch (SQLException e) {
			out.println("Product not created. Error Occured. " + e.getMessage());
			e.printStackTrace();
		}

		teacherUtil.getTeachers();
		request.setAttribute("teacher_list", teacherUtil.getTeachers());

		RequestDispatcher d = request.getRequestDispatcher("/showteacher.jsp");
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
