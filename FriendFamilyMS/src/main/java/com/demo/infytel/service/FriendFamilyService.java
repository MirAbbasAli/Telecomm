package com.demo.infytel.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.infytel.dto.FriendFamilyDTO;
import com.demo.infytel.entity.FriendFamily;
import com.demo.infytel.repository.FriendFamilyRepository;

@Service
public class FriendFamilyService {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FriendFamilyRepository friendFamilyRepo;
	
	// Create Friend Family
	public void saveFriend(Long phoneNo, FriendFamilyDTO friendDTO) {
		logger.info("Creation of request for customer with {} and with data {}",phoneNo, friendDTO);
		friendDTO.setPhoneNo(phoneNo);
		FriendFamily friend=friendDTO.createFriend();
		friendFamilyRepo.save(friend);
	}
	// Fetches friends phoneNo based on customer phoneNo
	public List<Long> getSpecificFriend(Long phoneNo) {
		logger.info("Friend and family details for customer {} ",phoneNo);
		List<Long> friendList=new ArrayList<Long>();
		List<FriendFamily> friends=friendFamilyRepo.findByPhoneNo(phoneNo);
		for(FriendFamily friendFamily: friends) {
			friendList.add(friendFamily.getFriendAndFamily());
		}
		logger.info("The friend list is for customer {} is {} ", phoneNo, friendList);
		return friendList;
	}
}
