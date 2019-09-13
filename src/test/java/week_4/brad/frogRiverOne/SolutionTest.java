package week_4.brad.frogRiverOne;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_4.brad.frogRiverOne.Solution.earliestTimeIndex;

/**
 * Created by betterfly
 * Date : 2019.09.15
 */
public class SolutionTest {
    int [] sample = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
    int [] sample2 = new int[]{2, 2, 2, 2, 2};
    int [] sample3 = new int[]{1, 4, 3, 2, 6};
    int [] sample4 = new int[]{2, 4, 3, 2, 5};
    int [] sample5 = new int[]{1, 3, 1, 3, 2, 1, 3};

    /*
    assertThat(earliestTimeIndex(3, sample5), is(4));
    아 말은 loop를 무조건끝까지 도는게 아니라, 순차적으로 X까지의 값이 검증되면 더이상 놀지 않아야함.
     */

    @Test
    public void 검증(){
        assertThat(earliestTimeIndex(5, sample), is(6));
        assertThat(earliestTimeIndex(2, sample2), is(-1));
        assertThat(earliestTimeIndex(5, sample3), is(-1));
        assertThat(earliestTimeIndex(5, sample4), is(-1));
        assertThat(earliestTimeIndex(3, sample5), is(4));
    }
}