package com.example.logtrace.trace.v4;

import com.example.logtrace.trace.v3.FieldLogTrace;
import com.example.logtrace.trace.v3.LogTrace;
import com.example.logtrace.trace.v3.ThreadLocalLogTrace;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractTemplateTest {
	
	@Test
	void testCase1() {
		AbstractTemplate<LogTrace> abstractTemplate1 = new SubClassLogic1<>(new ThreadLocalLogTrace());
		abstractTemplate1.execute("비즈니스 로직 1");
		
		AbstractTemplate<LogTrace> abstractTemplate2 = new SubClassLogic2(new ThreadLocalLogTrace());
		abstractTemplate2.execute("비즈니스 로직 2");
	}
	
	@DisplayName("다형성을 익명 클래스를 사용하여 구현하는 방식으로 객체 인스턴스 및 클래스 정의")
	@Test
	void testCase2() {
		AbstractTemplate<LogTrace> abstractTemplate1 = new AbstractTemplate<>(new ThreadLocalLogTrace()) {
			@Override
			protected LogTrace call() {
				System.out.println("비즈니스 로직 1 실행");
				return null;
			}
		};
		
		System.out.println("클래스 이름1 = " + abstractTemplate1.getClass());
		abstractTemplate1.execute("비즈니스 로직 1 실행");
		
		AbstractTemplate<LogTrace> abstractTemplate2 = new AbstractTemplate<>(new ThreadLocalLogTrace()) {
			@Override
			protected LogTrace call() {
				System.out.println("비즈니스 로직 2 실행");
				return null;
			}
		};
		
		System.out.println("클래스 이름2 = " + abstractTemplate2.getClass());
		abstractTemplate1.execute("비즈니스 로직 2 실행");
		
	}
}