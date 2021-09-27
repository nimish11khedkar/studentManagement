package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.model.FeedBack;
import com.management.model.Teacher;
import com.management.service.FeedBackService;
import com.management.service.TeacherService;

@Controller
public class FeedBackController {

	@Autowired
	private FeedBackService feedbackService;
	
	@GetMapping("/feedback")
	public ModelAndView gotoFeedBack() {
		ModelAndView model = new ModelAndView("feedback");
		List<Teacher> teacher = this.feedbackService.getTeachers();
		model.addObject("teachers" , teacher);
		return model;
	}
	
	@PostMapping("/add-feedback")
	public ModelAndView SendFeedback(@ModelAttribute("feedback")FeedBack feedback) {
		
		ModelAndView model = new ModelAndView("dashboard");
		this.feedbackService.SendFeedback(feedback);
		model.addObject("feedback" ,feedback);
		return model;
	}
	
}
