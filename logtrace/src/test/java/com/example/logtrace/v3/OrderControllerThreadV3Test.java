package com.example.logtrace.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class OrderControllerThreadV3Test {
	
	@Autowired
	private OrderControllerV3 orderControllerV3;
	
	private static final int THREAD_SIZE = 10;
	
	@DisplayName("스레드 테스트")
	@Test
	void testCase1() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_SIZE);
		CountDownLatch latch = new CountDownLatch(THREAD_SIZE);
		
		for (int i = 0; i < THREAD_SIZE; i++) {
			// 멀티 스레드 요청을 하는 코드
			executorService.execute(() -> {
				orderControllerV3.request("hello");
				latch.countDown();
				
			});
		}
		Thread.sleep(2000);
	}
}