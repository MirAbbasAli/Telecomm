package com.demo.infytel.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.infytel.dto.PlanDTO;
import com.demo.infytel.entity.Plan;
import com.demo.infytel.repository.PlanRepository;
@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepo;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	// Fetches all plan details
	public List<PlanDTO> getAllPlans() {
		List<Plan> plans = planRepo.findAll();
		List<PlanDTO> planDTOs = new ArrayList<PlanDTO>();

		for (Plan plan : plans) {
			PlanDTO planDTO = PlanDTO.valueOf(plan);
			planDTOs.add(planDTO);
		}

		logger.info("Plan details : {}", planDTOs);
		return planDTOs;
	}
	
	// Fetches Plan for a given plan Id
	public PlanDTO getSpecificPlan(int planId) {
		return PlanDTO.valueOf(planRepo.getById(planId));
	}
}
