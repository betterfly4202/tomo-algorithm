package week_2.brad.numberSolitaire;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_2.brad.numberSolitaire.Solution.dynamicProgramming;

/**
 * Created by betterfly
 * Date : 2019.08.28
 */
public class SolutionTest {

    private int [] sample = new int[]{1, -2, 0, 9, -1, -2};
    private int [] sample2 = new int[]{1, -2, 0, 9, -1, -2, 1, -5, 4, 11, -4, -2};
    private int [] sample3 = new int[]{-2, 5, 1};
    private int [] sample4 = new int[]{0, -4, -5, -2, -7, -9, -3, -10};
    private int [] sample5 = new int[]{-4, -10, -7};


    @Test
    public void dp_솔루션(){
//        assertThat(dynamicProgramming(sample), is(8));
        assertThat(dynamicProgramming(sample2), is(24));
//        assertThat(dynamicProgramming(sample3), is(4));
//        assertThat(dynamicProgramming(sample4), is(-12));
//        assertThat(dynamicProgramming(sample5), is(-11));
    }

}