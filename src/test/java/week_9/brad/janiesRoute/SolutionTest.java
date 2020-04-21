package week_9.brad.janiesRoute;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.11.13
 */
public class SolutionTest {
    @Test
    public void 검증(){
        int [] k = new int[10];
        int [][] l= new int[0][10];

        assertThat(Solution.jeanisRoute(k, l), is(6));;
    }

}