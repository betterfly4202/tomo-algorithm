package week_5.ruby;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PairsTest {
	@Test
	public void test() {
		//[5,3],[4,2],[3,1]
		assertEquals(Pairs.pairs(2, new int[]{1,5,3,4,2}), 3);
	}
}
