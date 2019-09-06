package week_2.brad.maxNonoverlappingSegments;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_2.brad.maxNonoverlappingSegments.Solution.greedyAlgorithm;

/**
 * Created by betterfly
 * Date : 2019.09.01
 */
public class SolutionTest {

    int [] A = new int []{1,3,7,9,9};
    int [] B = new int []{5,6,8,9,10};

    @Test
    public void 검증(){
        assertThat(greedyAlgorithm(A,B), is(3));
    }

}