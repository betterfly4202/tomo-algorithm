package week_2.ruby.greedyAlgorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
	private Solution solution = new Solution();
	
	@Test
	public void 테스트2() {
		assertEquals(solution.solution(
				new int[] {1,2}, 
				new int[] {2,3}
				), 0);
	}
}
