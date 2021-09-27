package com.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.FeedbackDao;
import com.management.model.FeedBack;
import com.management.model.Teacher;

@Service
public class FeedBackService {

	@Autowired
	private FeedbackDao feedbackDao;
	
	public void SendFeedback(FeedBack feedback) {
		// TODO Auto-generated method stub
		this.feedbackDao.SendFeedback(feedback);
	}

	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return this.feedbackDao.getTeachers();
	}
	
	
}
