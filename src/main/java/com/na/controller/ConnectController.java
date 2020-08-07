package com.na.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.na.service.ConnectService;

@RestController
public class ConnectController {
	
	
	
	@Autowired
	ConnectService connectService;
	
   
	@GetMapping("/connected")
	public ResponseEntity<String> checkOriginDestination(@RequestParam(required = false) String origin , @RequestParam(required = false) String destination ) {
		String result = connectService.checkIfOriginHasDestination(origin, destination);
		if(result.equals(ConnectService.YES)) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}

}
