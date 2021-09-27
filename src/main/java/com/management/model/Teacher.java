package com.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String department;
	private String subject;
	private String mobileNo;
	private String username;
	private String password;
	
//	@OneToOne
//	@JoinColumn(name="subject_id")
//	private Subjects subjects;
	
	
	public Teacher(int id, String firstname, String lastname, String email, String department, String subject,
			String mobileNo, String username, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.department = department;
		this.subject = subject;
		this.mobileNo = mobileNo;
		this.username = username;
		this.password = password;
		//this.subjects = subjects;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	public Subjects getSubjects() {
//		return subjects;
//	}
//	public void setSubjects(Subjects subjects) {
//		this.subjects = subjects;
//	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", department=" + department + ", subject=" + subject + ", mobileNo=" + mobileNo + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
}
