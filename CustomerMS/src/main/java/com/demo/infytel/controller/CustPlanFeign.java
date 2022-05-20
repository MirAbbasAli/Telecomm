package com.demo.infytel.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.infytel.dto.PlanDTO;

//url of api gateway
@FeignClient(name="PlanMS",url="http://localhost:9000/")
public interface CustPlanFeign {
	
	@RequestMapping(method=RequestMethod.GET,value="/plans/{planId}")
	PlanDTO getSpecificPlan(@PathVariable("planId") int planId);
}
