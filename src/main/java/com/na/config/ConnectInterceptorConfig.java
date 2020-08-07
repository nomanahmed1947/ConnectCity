package com.na.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.na.interceptor.ConnectInterceptor;

@Component
public class ConnectInterceptorConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private ConnectInterceptor connectInterceptor;
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(connectInterceptor);
	}
}

