package com.management.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.management.model.Subjects;

@Repository
public class SubjectDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired  
    SessionFactory sessionFactory;  
	
	
	
	@Transactional
	public void AddSubject(Subjects subjects) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(subjects);
	}

	public List<Subjects> getAllSubjects() {
		// TODO Auto-generated method stub
		List<Subjects> loadAll = this.hibernateTemplate.loadAll(Subjects.class);
		return loadAll;
	}

	@Transactional
	public void deleteSubject(int id) {
		// TODO Auto-generated method stub
		Subjects load = this.hibernateTemplate.load(Subjects.class, id);
		this.hibernateTemplate.delete(load);
	}

	public Subjects updateSubject(int id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Subjects.class, id);
	}

	@Transactional
	public List<Subjects> SearchByDepartment(String department, Subjects subjects) {
		// TODO Auto-generated method stub
		
		String sql = "from Subjects ur where ur.department=?";
		System.out.println("Subject Search DAO...");
		 Session currentSession = sessionFactory.getCurrentSession();  
		// currentSession.saveOrUpdate(department);  
		 boolean userFound = false;
		 
		 Query<Subjects> query = currentSession.createQuery(sql);
		 query.setParameter(0, subjects.getDepartment());
		 
		 List<Subjects> list = query.getResultList();
		
		 System.out.println(list);
		 System.out.println(subjects.getDepartment());
		 
		 
		return list;
	}

	@Transactional
	public List<Subjects> SearchBySubjectName(String subjectname, Subjects subjects) {
		// TODO Auto-generated method stub
		
		String sql = "from Subjects ur where ur.subjectname=?";
		System.out.println("Subject Search DAO...");
		 Session currentSession = sessionFactory.getCurrentSession();  
		// currentSession.saveOrUpdate(department);  
		
		 Query<Subjects> query = currentSession.createQuery(sql);
		 query.setParameter(0, subjects.getSubjectname());
		 
		 List<Subjects> list = query.getResultList();
		
		
		return list;
	}

	public List<Subjects> SearchByYear(String year, Subjects subjects) {
		// TODO Auto-generated method stub
		
		String sql = "from Subjects ur where ur.year=?";
		System.out.println("Year Search DAO...");
		 Session currentSession = sessionFactory.getCurrentSession();  
		// currentSession.saveOrUpdate(department);  
		
		 Query<Subjects> query = currentSession.createQuery(sql);
		 query.setParameter(0, subjects.getYear());
		 
		 List<Subjects> list = query.getResultList();
		
		return list;
	}

	@Transactional
	public List<Subjects> SearchByDepartmentANDYear(String department, String year, Subjects subjects) {
		// TODO Auto-generated method stub
		
		String sql = "from Subjects ur where ur.department=? and ur.year=?";
		System.out.println("DEPARTMENT & YEAR Search DAO...");
		 Session currentSession = sessionFactory.getCurrentSession();  
		// currentSession.saveOrUpdate(department);  
		
		 Query<Subjects> query = currentSession.createQuery(sql);
		 query.setParameter(0, subjects.getDepartment());
		 query.setParameter(1, subjects.getYear());
		 
		 List<Subjects> list = query.getResultList();
		
		
		return list;
	}

	
}
