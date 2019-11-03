package week_8.brad.biggerIsGreater;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.11.03
 */
public class SolutionTest {


    @Test
    public void 값찾기(){
        assertThat(Solution.biggerIsGreater("abdc"), is("acbd"));
        assertThat(Solution.biggerIsGreater("fedcbabcd"), is("fedcbabdc"));
        assertThat(Solution.biggerIsGreater("lmno"), is("lmon"));
        assertThat(Solution.biggerIsGreater("dcba"), is("no answer"));


        assertThat(Solution.biggerIsGreater("ab"), is("ba"));
        assertThat(Solution.biggerIsGreater("bb"), is("no answer"));
        assertThat(Solution.biggerIsGreater("hefg"), is("hegf"));
        assertThat(Solution.biggerIsGreater("dhck"), is("dhkc"));
        assertThat(Solution.biggerIsGreater("dkhc"), is("hcdk"));

        assertThat(Solution.biggerIsGreater("zyyyvvvvvuttsrqqokjjheedccb"), is("no answer"));
    }

    @Test
    public void 문자열삽입(){
        String a = "abbcd";
        String ss = Solution.switchingCharacter(a, 4,2);
        System.out.println(ss);

    }
}