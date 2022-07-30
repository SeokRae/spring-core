package com.example.logtrace.trace.v4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TemplateMethodTest {
	
	private TemplateMethod templateMethod;
	
	@BeforeEach
	void setUp() {
		templateMethod = new TemplateMethod();
	}
	
	@DisplayName("템플릿 메서드 1 테스트")
	@Test
	void templateMethodV0() {
		templateMethod.logic1();
		templateMethod.logic2();
	}
}