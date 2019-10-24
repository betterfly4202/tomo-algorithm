package week_7.bard.kangaroo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_7.bard.kangaroo.Solution.kangaroo;
import static week_7.bard.kangaroo.Solution.lcm;

/**
 * Created by betterfly
 * Date : 2019.10.23
 */
public class SolutionTest {

    @Test
    public void 최소공배수(){
//        assertThat(lcm(2,4), is(4));
//        assertThat(lcm(3,4), is(12));
//        assertThat(lcm(4,6), is(12));
        assertThat(lcm(4602 + 8519, 7585 + 8362), is(71235878));
    }

    @Test
    public void 검증(){
        assertThat(kangaroo(1,6,3,5), is("YES"));
        assertThat(kangaroo(2,6,4,5), is("YES"));
        assertThat(kangaroo(3,7,4,5), is("NO"));
        assertThat(kangaroo(4,6,5,5), is("YES"));

        // to do...
        assertThat(kangaroo(21,6,47,3), is("NO"));
        assertThat(kangaroo(4602, 8519, 7585 ,8362), is("YES"));
        assertThat(kangaroo(28, 8, 96, 2), is("NO"));
        assertThat(kangaroo(55, 8223, 5803, 6509), is("NO"));
        assertThat(kangaroo(2564, 5393, 5121, 2836), is("YES"));
    }
}