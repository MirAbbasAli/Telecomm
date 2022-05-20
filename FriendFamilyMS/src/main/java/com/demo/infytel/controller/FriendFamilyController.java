package com.demo.infytel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.infytel.dto.FriendFamilyDTO;
import com.demo.infytel.service.FriendFamilyService;

@RestController
@CrossOrigin
public class FriendFamilyController {

	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FriendFamilyService friendService;

	// Create Friend Family
	@RequestMapping(value="/customers/{phoneNo}/friends", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveFriend(@PathVariable Long phoneNo, @RequestBody FriendFamilyDTO friendDTO) {
		logger.info("Creation request for customer {} with data {}", phoneNo, friendDTO);
		friendService.saveFriend(phoneNo, friendDTO);
	}

	// Fetches friend and family numbers of a given customer phoneNo
	@RequestMapping(value="/customers/{phoneNo}/friends",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Long> getSpecificFriends(@PathVariable Long phoneNo){
		System.out.println("===== Fetching Data ====");
		logger.info("Friend and Family numbers for customer {}", phoneNo);
		// Introducing delay time of 5s
		/*try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}*/
		return friendService.getSpecificFriend(phoneNo);
	}
}
