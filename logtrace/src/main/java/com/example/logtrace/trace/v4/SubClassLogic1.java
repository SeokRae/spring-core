package com.example.logtrace.trace.v4;

import com.example.logtrace.trace.v3.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1<T> extends AbstractTemplate<T> {
	
	protected SubClassLogic1(LogTrace trace) {
		super(trace);
	}
	
	@Override
	protected T call() {
		log.info("비즈니스 로직 1 실행");
		return null;
	}
}
