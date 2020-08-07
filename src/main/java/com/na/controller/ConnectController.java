package com.na.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.na.service.ConnectService;

@RestController
public class ConnectController {
	
	@Autowired
	ConnectService connectService;
   
	@GetMapping("/connected")
	public String checkOriginDestination(@RequestParam(required = true) String origin , @RequestParam(required = true) String destination ) {
		return connectService.checkIfOriginHasDestination(origin, destination);
	}

}
