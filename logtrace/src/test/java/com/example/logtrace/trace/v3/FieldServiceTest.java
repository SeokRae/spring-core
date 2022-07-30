package com.example.logtrace.trace.v3;

import com.example.logtrace.trace.v3.solv.FieldService;
import org.junit.jupiter.api.Test;

class FieldServiceTest {
	
	private final FieldService fieldService = new FieldService();
	
	@Test
	void field() {
		Runnable userA = () -> {
			fieldService.logic("userA");
		};
		Runnable userB = () -> {
			fieldService.logic("userB");
		};
		
		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");
		
		threadA.start();
//        sleep(2000); //동시성 문제 발생X
		sleep(100); //동시성 문제 발생O
		threadB.start();
		
		sleep(3000); //메인 쓰레드 종료 대기
	}
	
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
