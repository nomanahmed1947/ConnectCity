package com.na;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.na.service.impl.ConnectServiceImpl;


@SpringBootTest
class ConnectedCityApplicationServiceTests {

	
	@InjectMocks
	ConnectServiceImpl connectService;
	
	@Mock
	Map<String, HashSet<String>> cityMap;

	@Test
	public void testConnectedServiceIfDestinationFound() throws Exception {
		
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Newark");
		when(cityMap.containsKey(Mockito.anyString())).thenReturn(true);
		when(cityMap.get(Mockito.anyString())).thenReturn(hashSet);
		String result = connectService.checkIfOriginHasDestination("Philadelphia", "Newark");
		assertEquals("yes", result);
	}

	@Test
	public void testConnectedServiceIfDestinationNotFound() throws Exception {
		
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("NoCity");
		when(cityMap.containsKey(Mockito.anyString())).thenReturn(true);
		when(cityMap.get(Mockito.anyString())).thenReturn(hashSet);
		String result = connectService.checkIfOriginHasDestination("Philadelphia", "Newark");
		assertEquals("no", result);
	}

}
