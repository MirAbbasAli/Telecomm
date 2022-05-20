package com.demo.infytel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.infytel.controller.CustFriendFeign;
import com.demo.infytel.controller.CustPlanFeign;
import com.demo.infytel.dto.PlanDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.concurrent.Future;

@Service
public class CustCircuitBreakerService {
	
	@Autowired
	private CustPlanFeign planFeign;
	
	@Autowired
	private CustFriendFeign friendFeign;
	
	@CircuitBreaker(name="customerService")
	public Future<PlanDTO> getSpecificPlan(Integer planId) {
		return Future.of(()->planFeign.getSpecificPlan(planId));
	}
	
	@CircuitBreaker(name="customerService")
	@SuppressWarnings("unchecked")
	public Future<List<Long>> getSpecificFriends(Long phoneNo) {
		return Future.of(()->friendFeign.getSpecificFriends(phoneNo));
	}
}
