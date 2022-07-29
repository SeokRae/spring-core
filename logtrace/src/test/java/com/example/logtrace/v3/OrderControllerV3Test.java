package com.example.logtrace.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerV3Test {
	
	@Autowired
	private MockMvc mockMvc;
	
	@DisplayName("정상 테스트")
	@Test
	void testCase1() throws Exception {
		mockMvc.perform(
				get("/v3/request")
					.param("itemId", "hello")
			)
			.andExpect(status().isOk());
	}
	
	@DisplayName("예외 테스트")
	@Test
	void testCase2() throws Exception {
		mockMvc.perform(
				get("/v3/request")
					.param("itemId", "ex")
			)
			.andExpect(status().isBadRequest());
	}
}