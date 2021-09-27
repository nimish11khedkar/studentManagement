package com.management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.management.model.FeedBack;
import com.management.model.Teacher;

@Repository
public class FeedbackDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
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
	public void SendFeedback(FeedBack feedback) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(feedback);
		sendSimpleEmail(feedback.getEmail(), "Hii thanks for feedback","Hii "+feedback.getName());
	}

	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		List<Teacher> loadAll = this.hibernateTemplate.loadAll(Teacher.class);
		
		
		
		return loadAll;
	}

	
}
