package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.FeesDao;
import com.management.model.FeesStructure;
import com.management.model.Subjects;
import com.management.model.Teacher;
import com.management.model.TeacherMap;

@Service
public class FeesService {

	@Autowired
	private FeesDao feesDao;
	
	
//	public List<Teacher> getTeacher() {
//		// TODO Auto-generated method stub
//		return this.mapDao.getTeacher();
//	}
//
//	public List<Subjects> getSubject() {
//		// TODO Auto-generated method stub
//		return this.mapDao.getSubject();
//	}

	public List<TeacherMap> teacherMapSubject(int t_id , int s_id ,Teacher teacher) {
		// TODO Auto-generated method stub
		return this.feesDao.teacherMapSubject(t_id , s_id , teacher);
	}

	public List<FeesStructure> getFees() {
		// TODO Auto-generated method stub
		
		return this.feesDao.getFees();
	}

	public void addFees(FeesStructure feesStructure) {
		// TODO Auto-generated method stub
		this.feesDao.addFees(feesStructure);
	}

	public FeesStructure getFeesByID(int id) {
		// TODO Auto-generated method stub
		return this.feesDao.getFeesByID(id);
	}

	public void UpdateFeesStructure(FeesStructure feesStructure) {
		// TODO Auto-generated method stub
		this.feesDao.UpdateFeesStructure(feesStructure);
	}

	public void deleteFees(int id) {
		// TODO Auto-generated method stub
		this.feesDao.deleteFees(id);
	}

	public List<FeesStructure> DownloadPDF() {
		// TODO Auto-generated method stub
		return this.feesDao.DownloadPDF();
	}

}
