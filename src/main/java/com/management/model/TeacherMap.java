package com.management.model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class TeacherMap {

	private String firstname;
	private String lastname;
	private String email;
	private String department;
	
	@OneToOne
	@JoinColumn(name="subject_id")
	private Subjects subjects;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public TeacherMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherMap(String firstname, String lastname, String email, String department, Subjects subjects) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.department = department;
		this.subjects = subjects;
	}
	
	
}
