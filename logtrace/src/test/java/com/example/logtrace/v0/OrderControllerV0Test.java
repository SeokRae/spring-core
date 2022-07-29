package com.example.logtrace.v0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerV0Test {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private OrderControllerV0 orderControllerV0;
	
	@Autowired
	private OrderServiceV0 orderServiceV0;
	
	@Autowired
	private OrderRepositoryV0 orderRepositoryV0;
	
	@DisplayName("정상 테스트")
	@Test
	void testCase1() throws Exception {
		mockMvc.perform(
			get("/v0/request")
				.param("itemId", "hello")
		)
			.andExpect(status().isOk());
	}
	
	@DisplayName("예외 테스트")
	@Test
	void testCase2() throws Exception {
		mockMvc.perform(
				get("/v0/request")
					.param("itemId", "ex")
			)
			.andExpect(status().isBadRequest());
	}
}