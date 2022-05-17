package com.demo.infytel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.infytel.dto.PlanDTO;
import com.demo.infytel.service.PlanService;

@RestController
@CrossOrigin
public class PlanController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PlanService planService;

	// Fetches all plan details
	@RequestMapping(value = "/plans", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans() {
		return planService.getAllPlans();
	}
	
	// Fetches Plan for a given planId
	@RequestMapping(value="/plans/{planId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getSpecificPlan(@PathVariable Integer planId){
		return planService.getSpecificPlan(planId);
	}
}
