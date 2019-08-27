package week_2.ruby.numberSolitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
	private Solution solution = new Solution();

	@Test
	public void 테스트케이스() {
		assertEquals(solution.solution(new int[] {1,-2,0,9,-1,-2}), 8);
	}
	
	@Test
	public void 음수만() {
		//assertEquals(solution.solution(new int[] {-1,-2,-3,-4,-5,-6,-7,-8,-9}), -1 -7 -9);
	}
	
	@Test
	public void 양수만() {
		//assertEquals(solution.solution(new int[] {1,2,3,4,5,6,7,8,9,10,11,12}), 
		//		1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12);
	}
}
