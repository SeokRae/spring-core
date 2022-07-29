package com.example.logtrace.trace.v1;

import com.example.logtrace.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {
	
	@DisplayName("로그 추적 시작 -> 끝")
	@Test
	void begin_end() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.end(status);
	}
	
	@DisplayName("로그 추적 시작 -> 예외")
	@Test
	void begin_exception() {
		HelloTraceV1 trace = new HelloTraceV1();
		TraceStatus status = trace.begin("hello");
		trace.exception(status, new IllegalStateException());
	}
}