package com.na.service;

public interface ConnectService {

	String YES = "yes";
	String No = "no";
	
	public String checkIfOriginHasDestination(String origin, String destination);
}
