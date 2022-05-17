package com.demo.infytel.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.infytel.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
}
