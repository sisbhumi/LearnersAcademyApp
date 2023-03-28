package com.backendadmin.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.backendadmin.domain.Student;
import com.backendadmin.domain.Subject;
import com.backendadmin.domain.Teacher;

public class SubjectUtil {

	private DataSource datasource;

	public SubjectUtil(DataSource datasource2) {
		this.datasource = datasource2;
	}

	public List<Subject> getSubject() {

		List<Subject> subjects = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = this.datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from subject order by id");
			while (resultset.next()) {
				
				int id = resultset.getInt("id");  
				String name = resultset.getString("sub_name");
				String clss = resultset.getString("class");
				Subject subject = new Subject(id,name,clss);
				subjects.add(subject);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return subjects;
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
