package com.demo.infytel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.infytel.dto.CustomerDTO;
import com.demo.infytel.dto.LoginDTO;
import com.demo.infytel.entity.Customer;
import com.demo.infytel.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	// Register a customer
	public void createCustomer(CustomerDTO customerDTO) {
		logger.info("Creation request for customer {}",customerDTO);
		Customer cust=customerDTO.createEntity();
		customerRepo.save(cust);
	}
	
	// Login a customer
	public Boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(), loginDTO.getPassword());
		Customer customer=customerRepo.findById(loginDTO.getPhoneNo()).get();
		if(customer!=null && customer.getPassword().equals(loginDTO.getPassword()))
			return true;
		return false;
	}
	
	// Fetches full profile of a specific customer
	public CustomerDTO getCustomerProfile(Long phoneNo) {
		logger.info("Profile request for customer {}",phoneNo);
		Customer customer=customerRepo.findById(phoneNo).get();
		CustomerDTO customerDTO=CustomerDTO.valueOf(customer);
		logger.info("Profile fur customer : {}",customerDTO);
		return customerDTO;
	}
}
