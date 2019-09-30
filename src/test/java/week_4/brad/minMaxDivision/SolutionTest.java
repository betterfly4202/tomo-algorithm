package week_4.brad.minMaxDivision;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_4.brad.minMaxDivision.Solution.getArraySum;

/**
 * Created by betterfly
 * Date : 2019.09.15
 */
public class SolutionTest {
    int [] sample = new int[]{2,1,5,1,2,2,2}; // <= 6.xxx
    int [] sample2 = new int[]{2,4,1,1,3,3,2,3,2,5}; // <= 10.xx
    int [] sample3 = new int[]{1,1,3,3,3,4,7,7,4,4,5,5,5};
    int [] sample4 = new int[]{3,1,2,2,3,4,5,7,4,8,5,3,3,4,2};
    int [] sample5 = new int[]{0};


    @Test
    public void 검증(){
        assertThat(Solution.minimumSum(3, 5, sample), is(6));
        assertThat(Solution.minimumSum(3, 5, sample2), is(10));
        assertThat(Solution.minimumSum(4, 7, sample3), is(15));
        assertThat(Solution.minimumSum(4, 8, sample4), is(16));
        assertThat(Solution.minimumSum(1, 1, sample5), is(0));
    }

    @Test
    public void 합산(){
        int a = getArraySum(sample);
        int b = getArraySum(sample2);
        int c = getArraySum(sample3);
        int d = getArraySum(sample4);

        System.out.println(a + " // " +(a+5)/3);
        System.out.println(b + " // " +(b+5)/3);
        System.out.println(c + " // " +(c+7)/4);
        System.out.println(d + " // " +(d+8)/4);
    }

    @Test
    public void sort(){
        Arrays.sort(sample2);
        System.out.println(Arrays.toString(sample2));

        Arrays.sort(sample3);
        System.out.println(Arrays.toString(sample3));
    }
}