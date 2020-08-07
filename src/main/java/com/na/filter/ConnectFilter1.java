package com.na.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConnectFilter1 implements Filter {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		LOGGER.info("Incoming  req : {}", req.getRequestURI());

		chain.doFilter(request, response);

		LOGGER.info("Outgoing req : {}", req.getRequestURI());

	}

}
