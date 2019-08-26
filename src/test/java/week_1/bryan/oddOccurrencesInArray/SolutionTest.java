package week_1.bryan.oddOccurrencesInArray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void NonPair() {
        int[] target = {9, 3, 9, 3, 9, 7, 9};
        assertEquals(7, solution.solution(target));
    }
}
