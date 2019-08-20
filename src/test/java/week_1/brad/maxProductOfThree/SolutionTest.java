package week_1.brad.maxProductOfThree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_1.brad.maxProductOfThree.Solution.maxResult;

/**
 * Created by betterfly
 * Date : 2019.08.15
 */
public class SolutionTest {
    int [] sample = new int[]{-3, 1, 2, -2, 5, 6};
    int [] sample2 = new int[]{1,2,3};
    int [] sample3 = new int[]{1,2,3,4};
    int [] sample4 = new int[]{0,-1,3,4};
    int [] sample5 = new int[]{-5, 5, -5, 4};
    int [] sample6 = new int[]{-2, -10, -3, 5, 41, 10, 3, -8}; // 410 / 205 * 3

    // 615,  20 41 820

    @Test
    public void 검증(){
        assertThat(maxResult(sample), is(60));
        assertThat(maxResult(sample2), is(6));
        assertThat(maxResult(sample3), is(24));
        assertThat(maxResult(sample4), is(0));
        assertThat(maxResult(sample5), is(125));
        assertThat(maxResult(sample6), is(80*41));
    }
}