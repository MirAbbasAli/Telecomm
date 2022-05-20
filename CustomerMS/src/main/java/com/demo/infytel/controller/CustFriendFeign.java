package com.demo.infytel.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="FriendFamilyMS",url="http://localhost:9000/")
public interface CustFriendFeign {
	
	@RequestMapping(method=RequestMethod.GET, value="/customers/{phoneNo}/friends")
	List<Long> getSpecificFriends(@PathVariable("phoneNo") Long phoneNo);
}
