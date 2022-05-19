package com.demo.infytel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.infytel.dto.CustomerDTO;
import com.demo.infytel.dto.LoginDTO;
import com.demo.infytel.dto.PlanDTO;
import com.demo.infytel.service.CustomerService;

@RefreshScope
@RestController
@CrossOrigin
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService custService;
	
	
	@Autowired 
	RestTemplate template;
	  	
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
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {

		logger.info("Profile request for customer {}", phoneNo);
		
		CustomerDTO custDTO=custService.getCustomerProfile(phoneNo);
		// Add rest endpoint to replace foreign key contraint for plan table
		PlanDTO planDTO=template.getForObject("http://PlanMS/plans/"+custDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		custDTO.setCurrentPlan(planDTO);

		@SuppressWarnings("unchecked")
		//		List<Long> friends=template.getForObject("http://MyLoadBalancer/customers/"+phoneNo+"/friends", List.class);
		List<Long> friends=template.getForObject("http://FriendFamilyMS/customers/"+phoneNo+"/friends", List.class);
		custDTO.setFriendAndFamily(friends);
		return custDTO;
	}
}
