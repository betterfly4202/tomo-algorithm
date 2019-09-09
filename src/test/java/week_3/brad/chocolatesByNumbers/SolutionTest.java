package week_3.brad.chocolatesByNumbers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_3.brad.chocolatesByNumbers.Solution.eatingCount;

/**
 * Created by betterfly
 * Date : 2019.09.08
 */
public class SolutionTest {
    int N = 10 , M = 4;
    int N1 = 50 , M1 = 6;
    int N2 = 100 , M2 = 10;
    int N3 = 18 , M3 = 12;

    @Test
    public void 검증(){
        assertThat(eatingCount(N,M), is(5));
        assertThat(eatingCount(N1,M1), is(25));
        assertThat(eatingCount(N2,M2), is(10));
        assertThat(eatingCount(N3,M3), is(3));

    }
}