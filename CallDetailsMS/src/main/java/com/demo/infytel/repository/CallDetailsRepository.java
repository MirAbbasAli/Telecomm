package com.demo.infytel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.infytel.entity.CallDetails;

public interface CallDetailsRepository extends JpaRepository<CallDetails, Long> {
	List<CallDetails> findByCalledBy(long calledBy);
}
