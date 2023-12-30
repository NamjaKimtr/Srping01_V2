package com.human.cafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		//fail("Not yet implemented");
		assertEquals("1", "1"); // 첫 번째 값과 두 번째 값이 같은지 확인
		assertNotNull(new ArrayList<String>()); // 객체가 null이 아닌지 확인
		
		/*
		1. assertEquals(a, b): a와 b의 값이 동일한지 확인
		2. assertSame(a, b): a와 b의 객체가 동일한지 확인
		3. assertNull(a): a가 null인지 확인
		4. assertNotNull(a): a가 null이 아닌지 확인
		5. assertTrue(a): a가 true인지 확인
		6. assertFalse(a): a가 false인지 확인
		 * 
		 */
	}

}
