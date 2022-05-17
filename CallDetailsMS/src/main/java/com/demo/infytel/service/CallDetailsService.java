package com.demo.infytel.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.infytel.dto.CallDetailsDTO;
import com.demo.infytel.entity.CallDetails;
import com.demo.infytel.repository.CallDetailsRepository;

@Service
public class CallDetailsService {
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CallDetailsRepository callDetailsRepo;

	// Fetches call details of a specific customer
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {

		logger.info("Calldetails request for customer {}", phoneNo);

		List<CallDetails> callDetails = callDetailsRepo.findByCalledBy(phoneNo);
		List<CallDetailsDTO> callsDTO = new ArrayList<CallDetailsDTO>();

		for (CallDetails call : callDetails) {
			callsDTO.add(CallDetailsDTO.valueOf(call));
		}
		logger.info("Calldetails for customer : {}", callDetails);

		return callsDTO;
	}
}
