package com.example.logtrace.trace.v5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContextV1Test {
	
	@Test
	void strategyV1() {
		StrategyLogic1 strategyLogic1 = new StrategyLogic1();
		ContextV1 context1 = new ContextV1(strategyLogic1);
		context1.execute();
		
		StrategyLogic2 strategyLogic2 = new StrategyLogic2();
		ContextV1 context2 = new ContextV1(strategyLogic2);
		context2.execute();
	}
	
	@DisplayName("특정 전략 구현 및 Context에 적용 테스트")
	@Test
	void strategyV2() {
		Strategy strategyLogic1 = new Strategy() {
			@Override
			public void call() {
				System.out.println("비즈니스 로직1 실행");
			}
		};
		ContextV1 context1 = new ContextV1(strategyLogic1);
		System.out.println("strategyLogic1 = " + strategyLogic1.getClass());
		context1.execute();
		
		Strategy strategyLogic2 = new Strategy() {
			@Override
			public void call() {
				System.out.println("비즈니스 로직2 실행");
			}
		};
		ContextV1 context2 = new ContextV1(strategyLogic2);
		System.out.println("strategyLogic2 = " + strategyLogic2.getClass());
		context2.execute();
	}
	
	@DisplayName("익명 클래스를 통한 전략 패턴 알고리즘 구현")
	@Test
	void strategyV3() {
		ContextV1 context1 = new ContextV1(new Strategy() {
			@Override
			public void call() {
				System.out.println("비즈니스 로직1 실행");
			}
		});
		context1.execute();
		
		ContextV1 context2 = new ContextV1(new Strategy() {
			@Override
			public void call() {
				System.out.println("비즈니스 로직2 실행");
			}
		});
		context2.execute();
	}
	
	@DisplayName("람다로 구현")
	@Test
	void strategyV4() {
		ContextV1 context1 = new ContextV1(() -> System.out.println("비즈니스 로직1 실행"));
		context1.execute();
		
		ContextV1 context2 = new ContextV1(() -> System.out.println("비즈니스 로직2 실행"));
		context2.execute();
	}
	
}
