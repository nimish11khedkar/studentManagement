package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.StudentDao;
import com.management.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentDao.addStudent(student);
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return this.studentDao.getStudents();
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		this.studentDao.deleteStudent(id);
	}

	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return this.studentDao.getStudentByID(id);
	}

	public List<Student> SearchByName(String name, Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.SearchByName(name , student);
	}

	public List<Student> SearchByDepartment(String dept, Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.SearchByDepartment(dept , student);
	}

	public List<Student> SearchByYear(String year, Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.SearchByYear(year , student);
	}

	public List<Student> getStudentByCast(String cast, Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.getStudentByCast(cast , student);
	}

	public List<Student> attendance() {
		// TODO Auto-generated method stub
		
		return this.studentDao.attendance();
	}

	public List<Student> UpdateAttendance(String attendance) {
		// TODO Auto-generated method stub
		return this.studentDao.UpdateAttendance(attendance);
	}
	
	
}
