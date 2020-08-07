package com.na.config;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ConnectConfig {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Bean
	public Map<String, HashSet<String>> cityMap() {
		Map<String, HashSet<String>> cityMap = new HashMap<String, HashSet<String>>();
		Resource resource = new ClassPathResource("city.txt");
		try {
			FileReader fr = new FileReader(resource.getFile());
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				StringTokenizer stk = new StringTokenizer(line, ",");
				String key = "";
				if (stk.hasMoreElements()) {
					key = (String) stk.nextElement();
					cityMap.putIfAbsent(key.trim(), new HashSet<String>());
				}
				while (stk.hasMoreElements()) {
					String city = (String) stk.nextElement();
					HashSet<String> citySet = cityMap.get(key);
					citySet.add(city.trim());
				}
			}
			fr.close();
			LOGGER.info("city Map ::: " + cityMap.toString());
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
		return cityMap;
	}
}
