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

import com.demo.infytel.dto.CallDetailsDTO;
import com.demo.infytel.service.CallDetailsService;

@RestController
@CrossOrigin
public class CallDetailsController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CallDetailsService callDetailsService;
	
	// Fetches call details of a specific customer
	@RequestMapping(value="/customers/{phoneNo}/calldetails",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo){
		logger.info("Calldetails request for customer {}", phoneNo);
		return callDetailsService.getCustomerCallDetails(phoneNo);
	}
}
