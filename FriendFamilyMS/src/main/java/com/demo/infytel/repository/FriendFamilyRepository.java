package com.demo.infytel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.infytel.entity.FriendFamily;

public interface FriendFamilyRepository extends JpaRepository<FriendFamily, Integer> {
	List<FriendFamily> findByPhoneNo(Long phoneNo);

}
