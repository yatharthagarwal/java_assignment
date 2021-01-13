package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Tour;

@Controller
public class ClientController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private ModelAndView mdlView;
	
	@Autowired
	private Tour tour;
	
	@GetMapping(path="/tour")
	public ModelAndView init() {		
		mdlView.setViewName("addTour");
		mdlView.addObject("command",tour);
		
		return mdlView;
	}
	
	@GetMapping(path="/updateTour")
	public ModelAndView update() {
		mdlView.setViewName("updateTour");
		mdlView.addObject("command",tour);
		return mdlView;
	}
	
	@GetMapping(path="/deleteTour")
	public ModelAndView delete() {
		mdlView.setViewName("deleteTour");
		mdlView.addObject("command",tour);
		return mdlView;
	}
	
	@PostMapping(path="/delete")
	public ModelAndView onDelete(@ModelAttribute("command") Tour tour) {
		this.template.delete("http://localhost:8080/api/v1/tours",tour);
		mdlView.setViewName("success");
		String added= "updated";
		mdlView.addObject("added",added);
		return mdlView;
	}
	
	@PostMapping(path="/update")
	public ModelAndView onUpdate(@ModelAttribute("command") Tour tour) {
		this.template.put("http://localhost:8080/api/v1/tours", tour);
		mdlView.setViewName("success");
		String added= "updated";
		mdlView.addObject("added",added);
		return mdlView; 
	}

	@PostMapping(path="/submit")
	public ModelAndView onSubmit(@ModelAttribute("command") Tour tour) {

		Tour added = this.template.postForObject("http://localhost:8080/api/v1/tours", tour, Tour.class);
		
		mdlView.setViewName("success");
		mdlView.addObject("added",added);
		return mdlView;
	}
}
