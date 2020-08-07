package com.na.service.impl;

import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.service.ConnectService;

@Service
public class ConnectServiceImpl implements ConnectService{

	@Autowired
	Map<String, HashSet<String>> cityMap;
	
	@Override
	public String checkIfOriginHasDestination(String origin, String destination) {
		String result = "no";
		if(cityMap.containsKey(origin)) {
			HashSet<String> citySet = cityMap.get(origin);
			if(citySet.contains(destination)) {
				result =  "yes";
			}
		}
		return result;
	}
	
	

}
