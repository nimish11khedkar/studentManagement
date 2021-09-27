package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.TeacherDao;
import com.management.model.Teacher;
import com.management.model.TeacherLogin;

@Service
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	public void AddTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		this.teacherDao.AddTeacher(teacher);
	}

	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return this.teacherDao.getTeachers();
	}

	public void deleteTeacher(int id) {
		// TODO Auto-generated method stub
		this.teacherDao.deleteTeacher(id);
	}

	public Teacher updateTeacher(int id) {
		// TODO Auto-generated method stub
		return this.teacherDao.updateTeacher(id);
	}

	public Teacher validateLogin(TeacherLogin login) {
		// TODO Auto-generated method stub
		return this.teacherDao.validateTeacher(login);
	}

	
}
