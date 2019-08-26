package week_2.ruby.numberSolitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
	private Solution solution = new Solution();

	@Test
	public void 테스트() {
		assertEquals(solution.solution(new int[] {1,-2,0,9,-1,-2}), 0);
	}
}
