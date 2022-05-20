package com.demo.infytel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.infytel.dto.CustomerDTO;
import com.demo.infytel.dto.LoginDTO;
import com.demo.infytel.dto.PlanDTO;
import com.demo.infytel.service.CustCircuitBreakerService;
import com.demo.infytel.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RefreshScope
@RestController
@CrossOrigin
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService custService;
	
	
	@Autowired 
	private CustCircuitBreakerService custCircuitBreakerService;
	
	// Create a new customer
	@RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO custDTO) {
		logger.info("Creation request for customer {}", custDTO);
		custService.createCustomer(custDTO);
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		return custService.login(loginDTO);
	}

	// Fetches full profile of a specific customer
	@RequestMapping(value = "/customers/{phoneNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name="customerService",fallbackMethod="getCustomerProfileFallback")
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {

		long overAllStart=System.currentTimeMillis();
		
		logger.info("Profile request for customer {}", phoneNo);
		CustomerDTO custDTO=custService.getCustomerProfile(phoneNo);
		
		long planStart=System.currentTimeMillis();
		
		// Add rest endpoint to replace foreign key contraint for plan table
		PlanDTO planDTO=custCircuitBreakerService.getSpecificPlan(custDTO.getCurrentPlan().getPlanId());
		
		long planStop=System.currentTimeMillis();
		
		custDTO.setCurrentPlan(planDTO);

		long friendStart=System.currentTimeMillis();
		
		//		List<Long> friends=template.getForObject("http://MyLoadBalancer/customers/"+phoneNo+"/friends", List.class);
		List<Long> friends=custCircuitBreakerService.getSpecificFriends(phoneNo);
		
		long friendStop=System.currentTimeMillis();
		
		custDTO.setFriendAndFamily(friends);
		
		long overAllStop=System.currentTimeMillis();
		
		logger.info("Total time for plan: "+(planStop-planStart));
		logger.info("Total time for friend: "+(friendStop-friendStart));
		logger.info("Total overall time for Request: "+(overAllStop-overAllStart));
		
		return custDTO;
	}
	
	public CustomerDTO getCustomerProfileFallback(Long phoneNo, Throwable throwable) {
		logger.info("================= In Fallback ========================");
		return new CustomerDTO();
	}
}
