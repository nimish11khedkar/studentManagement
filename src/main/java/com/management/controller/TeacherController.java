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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.management.model.Teacher;
import com.management.model.TeacherLogin;
import com.management.service.TeacherService;



@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/")
	public String home()
	{
		System.out.println("Home ....(teacher controller)");
		return "home";
	}
	
//	@GetMapping("/login")
//	public String showLoginPage()
//	{
//		System.out.println("Login....(teacher controller)");
//		return "login";
//	}
	
	@GetMapping("/register")
	public String showRegistrationPage()
	{
		System.out.println("Register....(Teacher controller)");
		return "registration";
	}
	
	//save teacher data
/*	@PostMapping("/teacher-register")
	public RedirectView AddTeacher(@ModelAttribute("teacher") Teacher teacher , HttpServletRequest req)
	{
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("dashboard");
		this.teacherService.AddTeacher(teacher);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
		return redirectView;
	}
	*/
	@PostMapping("/teacher-register")
	public ModelAndView AddTeacher(@ModelAttribute() Teacher teacher){
		this.teacherService.AddTeacher(teacher);
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("teacher" , teacher);
		return modelAndView;
	}
	
	
	@GetMapping("/dashboard")
	public String getBackTODashboard()
	{
		System.out.println("getBackTODashboard....(teacher Controller)");
		
		return "dashboard";
	}
	
	//get All teachers
	
	@GetMapping("/showAllTeachers")
	public String getAllTeachers(Model model)
	{
		System.out.println("Get All teachers....(teacher controller)");
		List<Teacher> teachers = this.teacherService.getTeachers();
		model.addAttribute("teachers" , teachers);
		return "allteachers";
	}
	
	//delete teacher
	@GetMapping("/delete/{id}")
	public RedirectView deletehandler(@PathVariable("id") int id , HttpServletRequest req)
	{
		
		System.out.println("delete teacher....(teacher controller)");
		this.teacherService.deleteTeacher(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/showAllTeachers");
		
		return redirectView;
	}
	
	//----------------
	
	
	//Update teacher
//	@GetMapping("/update/{id}")
//	public String updateTeacher(@PathVariable("id") int id , Model m)
//	{
//		System.out.println("update teacher......");
//		Teacher teacher = this.teacherService.updateTeacher(id);
//		m.addAttribute("teacher" , teacher);
//		return "updateteacher";
//	}

//	@GetMapping("/update/{id}")
//	public String updateTeacher(@PathVariable("id") int id , Model model)
//	{
//		
//		System.out.println("update teacher....(teacher controller)");
//		Teacher teacher = this.teacherService.updateTeacher(id);
//		model.addAttribute("teacher" , teacher);
//		return "update-teacher";
//	}
	
//	 @GetMapping("/update/{id}")
//	public ModelAndView updateTeacher(@PathVariable("id") int id , HttpServletRequest req)
//	{
//		
//		System.out.println("update teacher....(teacher controller)");
//		Teacher teacher = this.teacherService.updateTeacher(id);
//		ModelAndView model = new ModelAndView();
//		model.setViewName("updateteacher");
//		System.out.println("set view name");
//		model.addObject("teacher" , teacher);
//		System.out.println("set object");
//		return model;
//	} 
	
	
	@GetMapping("/update/{id}")
	public String updatehandler(@PathVariable("id") int id , Model model)
	{
		System.out.println("update...controller");
		Teacher teacher = this.teacherService.updateTeacher(id);
		model.addAttribute("teacher" , teacher);
		return "updateteacher";
	}
	
	
	
	
	
	
	
	
	
	//---------------------------------
	//---------------------------------LOGIN controller
	//---------------------------------

	@GetMapping("/login")
	public ModelAndView showLogin()
	{
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("teacherLogin" , new TeacherLogin());
		return modelAndView;
	}
	
	@PostMapping("/teacher-login")
	public ModelAndView loginProcess(@ModelAttribute("login") TeacherLogin login)
	{
		ModelAndView modelAndView = null;
		Teacher teacher = this.teacherService.validateLogin(login);
		if(null != teacher ) {
			System.out.println("login....(teacher controller) IF-CON");
			modelAndView = new ModelAndView("dashboard");
			modelAndView.addObject("firstname"  , teacher.getFirstname()+" "+teacher.getLastname());
		}else {
			System.out.println("login....(teacher controller) ELSE-CON");
			modelAndView = new ModelAndView("login");
			modelAndView.addObject("message" ,"username & password Incorrect");
		}
		return modelAndView;
	}

}
