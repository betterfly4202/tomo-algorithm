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
    public void plus() {
        int[] target = {1, 4, 7, 3, 2, 5};
        assertEquals(140, solution.solution(target));
    }

    @Test
    public void minus(){
        int[] target = {-3, -1, -4, -2, -5, -6};
        assertEquals(-6, solution.solution(target));
    }

    @Test
    public void plus_minus(){
        int[] target = {-3, -1, -2, -2, 5, 6};
        assertEquals(36, solution.solution(target));
    }
}
