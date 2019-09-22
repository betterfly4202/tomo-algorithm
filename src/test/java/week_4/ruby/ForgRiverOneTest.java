package week_4.ruby;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ForgRiverOneTest {
	ForgRiverOne fr = new ForgRiverOne();
	
	@Test
	public void test() {
		assertEquals(fr.solution(5, new int[]{1,3,1,4,2,3,5,4}), 6);
		assertEquals(fr.solution(6, new int[]{1,3,1,4,2,3,5,4}), -1);
		assertEquals(fr.solution(1, new int[]{1}), 0);
	}
}
