package com.na;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.na.controller.ConnectController;
import com.na.service.impl.ConnectServiceImpl;


@SpringBootTest
class ConnectedCityApplicationControllerTests {

	@InjectMocks
	ConnectController connectController;
	
	@Mock
	ConnectServiceImpl connectService;
	
	

	@Test
	public void testConnectedController() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(connectController).build();
		when(connectService.checkIfOriginHasDestination(Mockito.anyString(), Mockito.anyString())).thenReturn("yes");
		mockMvc.perform(MockMvcRequestBuilders.get("/connected").param("origin", "Philadelphia").param("destination", "Newark"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("yes")

		);
	}
}
