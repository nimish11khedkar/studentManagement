package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.dao.SubjectDao;
import com.management.model.Subjects;

@Service
public class SubjectService {

	@Autowired
	private SubjectDao subjectDao;
	
	public void AddSubject(Subjects subjects) {
		// TODO Auto-generated method stub
		this.subjectDao.AddSubject(subjects);
	}

	public List<Subjects> getAllSubjects() {
		// TODO Auto-generated method stub
		return this.subjectDao.getAllSubjects();
	}

	public void deleteSubject(int id) {
		// TODO Auto-generated method stub
		this.subjectDao.deleteSubject(id);
	}

	public Subjects updateSubject(int id) {
		// TODO Auto-generated method stub
		return this.subjectDao.updateSubject(id);
	}

	public List<Subjects> SearchByDepartment(String department, Subjects subjects) {
		// TODO Auto-generated method stub
		return this.subjectDao.SearchByDepartment(department, subjects);
	}

	public List<Subjects> SearchBySubjectName(String subjectname, Subjects subjects) {
		// TODO Auto-generated method stub
		return this.subjectDao.SearchBySubjectName(subjectname, subjects);
	}

	public List<Subjects> SearchByYear(String year, Subjects subjects) {
		// TODO Auto-generated method stub
		return this.subjectDao.SearchByYear(year,subjects);
	}

	public List<Subjects> SearchByDepartmentANDYear(String department, String year, Subjects subjects) {
		// TODO Auto-generated method stub
		return this.subjectDao.SearchByDepartmentANDYear(department , year , subjects);
	}

}
