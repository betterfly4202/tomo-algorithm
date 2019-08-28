package week_2.ruby.greedyAlgorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
	private Solution solution = new Solution();
	
	@Test
	public void 테스트2() {
		assertEquals(solution.solution(
				new int[] {1,3,7,9,9}, 
				new int[] {5,6,8,9,10}
				), 3);
	}
}
