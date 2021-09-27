package com.management.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.management.model.Teacher;

public class TeacherMapper implements RowMapper<Teacher> {

	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Teacher t = new Teacher();
		t.setFirstname(rs.getString("firstname"));
		t.setLastname(rs.getString("lastname"));
		t.setEmail(rs.getString("email"));
		t.setDepartment(rs.getString("department"));
		t.setSubject(rs.getString("subject"));
		t.setMobileNo(rs.getString("mobileNo"));
		t.setUsername(rs.getString("username"));
		t.setPassword(rs.getString("password"));
		
			
		
		return t;
	}

}
