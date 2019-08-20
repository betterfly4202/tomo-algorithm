package week_1.brad.oddOccurrencesInArray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_1.brad.oddOccurrencesInArray.Solution.unpairedValue;

/**
 * Created by betterfly
 * Date : 2019.08.15
 */
public class SolutionTest {
    int [] sample = new int[]{9,3,9,3,9,7,9};
    int [] sample2 = new int[]{2, 4, 2, 5, 4, 5, 1};
    int [] sample3 = new int[]{2, 4, 2, 5, 4, 5, 9};

    @Test
    public void 검증(){
        assertThat(unpairedValue(sample), is(7));
        assertThat(unpairedValue(sample2), is(1));
        assertThat(unpairedValue(sample3), is(9));
    }
}