package com.example.logtrace.trace.v5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContextV1Test {
	
	@Test
	void testCase1() {
		Strategy strategyLogic1 = new StrategyLogic1();
		ContextV1 contextV1 = new ContextV1(strategyLogic1);
		contextV1.execute();
		
		Strategy strategyLogic2 = new StrategyLogic2();
		ContextV1 contextV2 = new ContextV1(strategyLogic2);
		contextV2.execute();
	}
}