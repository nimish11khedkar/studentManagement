package com.management.config;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

public class EmailSenderService {

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
	
	
	public void sendEmailWithAttachment(String toEmail ,
			String body ,
			String subject ,
			String attachment) throws MessagingException {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper mime = new MimeMessageHelper(mimeMessage , true);
		
		mime.setFrom("khedkarnimish@gmail.com");
		mime.setTo(toEmail);
		mime.setText(body);
		mime.setSubject(subject);
		
		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
		
		mime.addAttachment(fileSystem.getFilename(), fileSystem);
		
		mailSender.send(mimeMessage);
		
		System.out.println("Mail send with Attachments....!");
	}
	
	
	
}
