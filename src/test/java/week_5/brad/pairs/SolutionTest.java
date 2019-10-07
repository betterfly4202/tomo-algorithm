package week_5.brad.pairs;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_5.brad.pairs.Solution.pairsResult;

/**
 * Created by betterfly
 * Date : 2019.09.29
 */
public class SolutionTest {
    int [] sample = new int[]{1, 5, 3, 4, 2};
    int [] sample2 = new int[]{363374326,364147530,61825163,1073065718,1281246024,1399469912,428047635,491595254,879792181,1069262793};
    

    @Test
    public void 검증(){
        assertThat(pairsResult(sample, 2), is(3));
        assertThat(pairsResult(sample2, 1), is(0));
    }
}