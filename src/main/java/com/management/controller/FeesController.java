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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.management.model.FeesStructure;
import com.management.model.Subjects;
import com.management.model.Teacher;
import com.management.model.TeacherMap;
import com.management.service.FeesService;

@Controller
public class FeesController {

	@Autowired
	private FeesService mapService;

	@GetMapping("/teacher-subject-map")
	public String getMap() {
		System.out.println("teacher-subject-map  --> fees Controller");
		return "teacher-subject-map";
	}

	@GetMapping("/teacher-subject")
	public ModelAndView getMapping(@RequestParam("id") int t_id, @RequestParam("id") int s_id,
			@ModelAttribute("teacher") Teacher teacher) {
		System.out.println("map controller...");
		List<TeacherMap> teachers = this.mapService.teacherMapSubject(t_id, s_id, teacher);
		ModelAndView modelAndView = new ModelAndView("teacher-subject-map");
		modelAndView.addObject("teachers", teachers);
		return modelAndView;
	}
	// ---------------------------------------------------
	// ---------------------------------------------------
	// ---------------------------------------------------

	@GetMapping("/all-fees-structure")
	public String getFees(Model model) {
		System.out.println("fees-structure --> GetFees");
		List<FeesStructure> fees = this.mapService.getFees();
		model.addAttribute("fees", fees);
		return "all-fees-structure";
	}

	@GetMapping("/add-fees")
	public String addFeesGET() {

		return "add-fees-structure";
	}

	@PostMapping("/add-fees")
	public ModelAndView addFees(@ModelAttribute("feesStructure") FeesStructure feesStructure) {

		System.out.println("Post mapping --> fees controller");

		this.mapService.addFees(feesStructure);
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("feesStructure", feesStructure);

		System.out.println("return object feeStructure ");
		return modelAndView;
	}

	//DELETE
	@GetMapping("/delete-fees/{id}")
	public RedirectView deleteFees(@PathVariable("id")int id , HttpServletRequest req)
	{
		
		System.out.println("Delete amounts fees");
		this.mapService.deleteFees(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/all-fees-structure");
		return redirectView;
	}
	
	
	
	
	// update
	@GetMapping("/update-fees/{id}")
	public String gotoUpdateFee(@PathVariable("id") int id, Model model) {

		System.out.println("pdate-fees --> (FEES controller)");

		FeesStructure fees = this.mapService.getFeesByID(id);
		model.addAttribute("fees", fees);
		return "update-fees";
	}

	@PostMapping("/add-fees-post")
	public ModelAndView UpdateFees(@ModelAttribute("feesStructure") FeesStructure feesStructure) {
		System.out.println("UPDATE --> (add-fees-post CONTROLLER)");
		ModelAndView modelAndView = new ModelAndView("dashboard");

		this.mapService.UpdateFeesStructure(feesStructure);
		// modelAndView.addObject("feesStructure" , feesStructure);
		//
		if (feesStructure.getPaidAmount() == feesStructure.getTotalAmount()) {
			feesStructure.setStatus("Amount Paid");

			System.out.println("Status : " + feesStructure.getStatus());
		}

		System.out.println("COMPLETION...");
		return modelAndView;
	}

	
	/////////////////
	////////////////
	
	@GetMapping("/download-pdf")
	public String DownloadPDF(Model model) {
		/* List<FeesStructure> fees = this.mapService.getFees();
		model.addAttribute("fees", fees);
		return "all-fees-structure";  */
		List<FeesStructure> fees = this.mapService.DownloadPDF();
		model.addAttribute("fees" , fees);
		return "all-fees-structure";
	}
	
	
	
}
