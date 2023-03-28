package com.backendadmin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.backendadmin.domain.ClassRoom;
import com.backendadmin.domain.Student;
import com.backendadmin.domain.Subject;
import com.backendadmin.domain.Teacher;

public class ClassUtil {

	public DataSource datasource;

	public ClassUtil(DataSource datasource2) {
		this.datasource = datasource2;
	}

	public List<ClassRoom> getClasses() {

		List<ClassRoom> classes = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = this.datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from class order by id");
			while (resultset.next()) {
				String name = resultset.getString("classname");
				ClassRoom classR = new ClassRoom(name);
				classes.add(classR);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return classes;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
