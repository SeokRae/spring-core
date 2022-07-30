package com.example.logtrace.trace.v4;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethod {
	
	protected void logic1() {
		long startTime = System.currentTimeMillis();
		/* 비즈니스 로직 실행 */
		log.info("비즈니스 로직 1 실행");
		/* 비즈니스 로직 종료 */
		
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}
	
	protected void logic2() {
		long startTime = System.currentTimeMillis();
		
		/* 비즈니스 로직 실행 */
		log.info("비즈니스 로직 2 실행");
		/* 비즈니스 로직 종료 */
		
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTime = {}", resultTime);
	}
}
