package com.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.management.model.Subjects;
import com.management.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	
	@GetMapping("dashboard-subject")
	public String dashBoard()
	{
		System.out.println("subject dashboard --> (subject sontrol)");
		return "dashboard";
	}
	
	//All subjects 
	@GetMapping("all-subjects")
	public String getAllSubjects(Model model)
	{
		System.out.println("all-subjects---> (subject controller)");
		List<Subjects> subjectss = subjectService.getAllSubjects();
		model.addAttribute("subjectss" , subjectss);
		return "all-subjects";
	}
	
	//for just calling after updating or adding
	@GetMapping("all-subjects-pre")
	public String getALL() {
		
		System.out.println("all-subjects-pre...");
		return "all-subjects";
	}
	
	
	
	//go to the Add-Subject
	@GetMapping("/add-subject")
	public String getAddSubject()
	{
		System.out.println("getMap add-subject--> (subject controller)");
		return "add-subject";
	}
	 
	//Add Subject
	@PostMapping("/add-subject-post")
	public ModelAndView AddSubject(@ModelAttribute() Subjects subjects , HttpServletRequest req) {
		
		System.out.println("PostMap Add Subject-->(subject Controller)");
		this.subjectService.AddSubject(subjects);
		ModelAndView model = new ModelAndView();
		model.setViewName("/dashboard");
		model.addObject("subjects" , subjects);
		return model;
	}
	
	
	//delete 
	@GetMapping("/delete-subject/{id}")
	public RedirectView deleteSubject(@PathVariable("id") int id , HttpServletRequest req)
	{
		System.out.println("Delete subject..");
		this.subjectService.deleteSubject(id);
		RedirectView r = new RedirectView();
		r.setUrl(req.getContextPath()+"/all-subjects");
		return r;
	}
	
	//update get
	@GetMapping("/update-subject/{id}")
	public String updateSubject(@PathVariable("id")int id, Model model)
	{
		System.out.println("Update student GET");
		Subjects subject = this.subjectService.updateSubject(id);
		model.addAttribute("subject" , subject);
		return "update-subject";
	}
	
	//Search by methods
	@GetMapping("/subjectSearch")
	public ModelAndView subjectSearch(@RequestParam("subjectname")String subjectname ,
			@RequestParam("department")String department , 
			@RequestParam("year")String year , 
			@ModelAttribute("subjects") Subjects subjects) {
		
		
		System.out.println("subjectSearch run--> ");
		ModelAndView modelAndView = new ModelAndView("all-subjects");
		
		if(subjectname =="" && year == "") {
			List<Subjects> subject = this.subjectService.SearchByDepartment(department,subjects);
			modelAndView.addObject("subjectss" , subject);
			System.out.println("Inside IF CON in subject search for Department");
			
			
		}else if(department=="" && year=="") {
			List<Subjects> subject = this.subjectService.SearchBySubjectName(subjectname , subjects);
			modelAndView.addObject("subjectss" , subject);
			System.out.println("inside subject name search");
		
		}else if(subjectname=="" && department=="") {
			List<Subjects> subject = this.subjectService.SearchByYear(year , subjects);
			modelAndView.addObject("subjectss" , subject);
			System.out.println("inside year search");
		}else if(subjectname=="") {
			List<Subjects> subject = this.subjectService.SearchByDepartmentANDYear(department , year , subjects);
			modelAndView.addObject("subjectss" , subject);
			System.out.println("inside DEPARTMENT & YEAR search");
		}
		
		return modelAndView;
	}
	
	
	
}
