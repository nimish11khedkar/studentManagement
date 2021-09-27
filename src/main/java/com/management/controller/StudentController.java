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

import com.management.model.Student;
import com.management.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	//go inside in stduent years
	@GetMapping("/student-years")
	public String getStudentYears(Model model)
	{
		System.out.println("student Years ...(Student controller)");
		
		return "student-years";
	}
	
	
	
	
	@GetMapping("/add-student")
	public String getAddStudent()
	{
		System.out.println("getmapped add-student ");
		return "add-student";
	}
	
	
	@PostMapping("/add-student")
	public ModelAndView AddStudent(@ModelAttribute("student") Student student)
	{
		System.out.println("add student ----(Student Controller)");
		this.studentService.addStudent(student);
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("student" ,student );
		return modelAndView;
	}
	
	//All Student 
	@GetMapping("/all-students")
	public String getStudentDetails(Model m)
	{
		System.out.println("all students GETMAP (student controller)");
		List<Student> students = studentService.getStudents();
		m.addAttribute("students" , students); 
		return "all-students";
	}
	
	//delete student
	@GetMapping("/delete-student/{id}")
	public RedirectView deleteStudent(@PathVariable("id")int id , HttpServletRequest req){
		
		System.out.println("delete Student...(Student controller)");
		this.studentService.deleteStudent(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/all-students");
		return redirectView;
	}

	
	
	//update Student
	@GetMapping("/update-student/{id}")
	public String updateStudent(@PathVariable()int id , Model model) {
		
		System.out.println("update....(Student controller)");
		
		Student student = this.studentService.getStudentByID(id);
		model.addAttribute("student" , student);
		
		System.out.println("Qyery RUN");
		return "update-student";
	}

	
	
	//--------------------------------------------------------------
	//--------------------------------------------------------------
	
	//Search methods
	@GetMapping("/studentSearch")
	public ModelAndView studentSearch(@RequestParam("firstname")String name , 
			@RequestParam("dept") String dept , 
			@RequestParam("year")String year , @ModelAttribute("student")Student student) {
	
		System.out.println("Search methods in stduent controller");
		
		ModelAndView modelAndView = new ModelAndView("all-students");
		
		if(dept=="" && year=="") {
		
			System.out.println("Search By name ");
			List<Student> students = this.studentService.SearchByName(name , student);
			modelAndView.addObject("students" , students);
		
		}else if(name=="" && year=="") {
			System.out.println("Search by Department");
			List<Student> students = this.studentService.SearchByDepartment(dept , student);
			modelAndView.addObject("students" , students);
		}else if(dept=="" && name=="") {
			System.out.println("Search by Year");
			List<Student> students = this.studentService.SearchByYear(year , student);
			modelAndView.addObject("students" , students);	
		}
		
		return modelAndView;
	}


	//--------------ATTENDance------------
	
	@GetMapping("/Attendance")
	public String gotoAttendanceSearch(Model model) {
		
		List<Student> students = studentService.attendance();
		model.addAttribute("students" , students);
		return "attendance";
	}
	
	
	@GetMapping("/AttendanceSearch")
	public ModelAndView gotoAttendanceSearchByCAST(@RequestParam("cast")String cast , @ModelAttribute("student")Student student) {
		
		
		ModelAndView modelAndView = new ModelAndView("attendance");
		List<Student> students = this.studentService.getStudentByCast(cast , student);
		return modelAndView;
	}
	
	@GetMapping("/update-Attendance")
	public RedirectView UpdateAttendance(@RequestParam("attendance") String attendance , Model model , HttpServletRequest req) {
		List<Student> students = this.studentService.UpdateAttendance(attendance);
		model.addAttribute("students" , students);
		RedirectView r = new RedirectView();
		r.setUrl(req.getContextPath()+"/Attendance");
		return r;
	}
	
	
}
