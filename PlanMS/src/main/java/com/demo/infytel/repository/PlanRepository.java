package com.demo.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.infytel.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
