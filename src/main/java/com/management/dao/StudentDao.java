package com.management.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.management.model.Student;

@Repository
public class StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail , 
			String body , 
			String subject) {
		
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("khedkarnimish@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		
		System.out.println("MAil Send....");
	}
	
	
	@Transactional
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.saveOrUpdate(student);
		
		sendSimpleEmail(student.getEmail(), "Welcome ", "Welcome " + student.getFirstname());
		}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student s = this.hibernateTemplate.load(Student.class, id);
		this.hibernateTemplate.delete(s);
	}

	// get Student by ID
	public Student getStudentByID(int id) {
		return this.hibernateTemplate.get(Student.class, id);
	}

	@Transactional
	public List<Student> SearchByName(String name, Student student) {
		// TODO Auto-generated method stub

		String sql = "from Student ur where ur.firstname=?";
		System.out.println("Name Search DAO...");
		Session currentSession = sessionFactory.getCurrentSession();
		// currentSession.saveOrUpdate(department);

		Query<Student> query = currentSession.createQuery(sql);
		query.setParameter(0, student.getFirstname());

		List<Student> list = query.getResultList();

		return list;
	}

	@Transactional
	public List<Student> SearchByDepartment(String dept, Student student) {
		// TODO Auto-generated method stub
		String sql = "from Student ur where ur.dept=?";
		System.out.println("Department Search DAO...");
		Session currentSession = sessionFactory.getCurrentSession();
		// currentSession.saveOrUpdate(department);

		Query<Student> query = currentSession.createQuery(sql);
		query.setParameter(0, student.getDept());

		List<Student> list = query.getResultList();

		return list;
	}

	@Transactional
	public List<Student> SearchByYear(String year, Student student) {
		// TODO Auto-generated method stub
		String sql = "from Student ur where ur.year=?";
		System.out.println("Year Search DAO...");
		Session currentSession = sessionFactory.getCurrentSession();
		// currentSession.saveOrUpdate(department);

		Query<Student> query = currentSession.createQuery(sql);
		query.setParameter(0, student.getYear());

		List<Student> list = query.getResultList();

		return list;
	}

	public List<Student> getStudentByCast(String cast, Student student) {
		// TODO Auto-generated method stub

		List<Student> students = this.hibernateTemplate.loadAll(Student.class);

		// List<Student> newList = students.stream().filter(s ->
		// s.getCast().contains("OPEN")).col;

		return null;
	}

	public List<Student> attendance() {
		// TODO Auto-generated method stub
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);

		return students;
	}

	public List<Student> UpdateAttendance(String attendance) {
		// TODO Auto-generated method stub
		
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
	//	List<Student> list = students.stream().filter(s -> s.getAttendance().equals(attendance)).collect(Collectors.toList());
		
		return null;
	}

	// get Stduent list by ID

}
