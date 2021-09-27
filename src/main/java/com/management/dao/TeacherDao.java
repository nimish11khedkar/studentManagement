package com.management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.management.model.Teacher;
import com.management.model.TeacherLogin;


@Repository
public class TeacherDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Transactional
	public void AddTeacher(Teacher teacher)
	{
		this.hibernateTemplate.saveOrUpdate(teacher);
	}
	
	@Transactional
	public void deleteTeacher(int id)
	{
		Teacher p = this.hibernateTemplate.load(Teacher.class, id);
		this.hibernateTemplate.delete(p);
	}
	
	public Teacher updateTeacher(int id)
	{
		Teacher teacher = this.hibernateTemplate.get(Teacher.class,id);
		return teacher;
	}

	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		List<Teacher> teachers = this.hibernateTemplate.loadAll(Teacher.class);
		return teachers;
	}

	public Teacher validateTeacher(TeacherLogin login) {
		String sql = "select * from teacher where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
		
		List<Teacher> query = this.JdbcTemplate.query(sql, new TeacherMapper());
		return query.size() > 0 ? query.get(0) : null;
		
	}
	
}
