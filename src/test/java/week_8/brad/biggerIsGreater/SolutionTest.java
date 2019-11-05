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
        assertThat(Solution.biggerIsGreater("mhtvaqofxtyrz"), is("mhtvaqofxtyzr"));
        assertThat(Solution.biggerIsGreater("dkhc"), is("hcdk"));

        assertThat(Solution.biggerIsGreater("abdc"), is("acbd"));
        assertThat(Solution.biggerIsGreater("fedcbabcd"), is("fedcbabdc"));
        assertThat(Solution.biggerIsGreater("lmno"), is("lmon"));
        assertThat(Solution.biggerIsGreater("dcba"), is("no answer"));
        assertThat(Solution.biggerIsGreater("ab"), is("ba"));
        assertThat(Solution.biggerIsGreater("bb"), is("no answer"));
        assertThat(Solution.biggerIsGreater("hefg"), is("hegf"));
        assertThat(Solution.biggerIsGreater("dhck"), is("dhkc"));

        assertThat(Solution.biggerIsGreater("zyyyvvvvvuttsrqqokjjheedccb"), is("no answer"));
        assertThat(Solution.biggerIsGreater("imllmmcslslkyoegymoa"), is("imllmmcslslkyoegyoam"));
        assertThat(Solution.biggerIsGreater("fvincndjrurfh"), is("fvincndjrurhf"));
        assertThat(Solution.biggerIsGreater("rtglgzzqxnuflitnlyit"), is("rtglgzzqxnuflitnlyti"));

        assertThat(Solution.biggerIsGreater("zalqxykemvzzgaka"), is("zalqxykemvzzgkaa"));
        assertThat(Solution.biggerIsGreater("wjjulziszbqqdcpdnhdo"), is("wjjulziszbqqdcpdnhod"));
        assertThat(Solution.biggerIsGreater("japjbvjlxzkgietkm"), is("japjbvjlxzkgietmk"));
        assertThat(Solution.biggerIsGreater("jqczvgqywydkunmjw"), is("jqczvgqywydkunmwj"));
        assertThat(Solution.biggerIsGreater("ehdegnmorgafrjxvksc"), is("ehdegnmorgafrjxvsck"));
    }


    @Test
    public void 첫_테스트(){
        assertThat(FirstSolution.biggerIsGreater("abdc"), is("acbd"));
        assertThat(FirstSolution.biggerIsGreater("fedcbabcd"), is("fedcbabdc"));
        assertThat(FirstSolution.biggerIsGreater("lmno"), is("lmon"));
        assertThat(FirstSolution.biggerIsGreater("dcba"), is("no answer"));
        assertThat(FirstSolution.biggerIsGreater("ab"), is("ba"));
        assertThat(FirstSolution.biggerIsGreater("bb"), is("no answer"));
        assertThat(FirstSolution.biggerIsGreater("hefg"), is("hegf"));
        assertThat(FirstSolution.biggerIsGreater("dhck"), is("dhkc"));

        assertThat(FirstSolution.biggerIsGreater("zyyyvvvvvuttsrqqokjjheedccb"), is("no answer"));
        assertThat(FirstSolution.biggerIsGreater("imllmmcslslkyoegymoa"), is("imllmmcslslkyoegyoam"));
        assertThat(FirstSolution.biggerIsGreater("fvincndjrurfh"), is("fvincndjrurhf"));
        assertThat(FirstSolution.biggerIsGreater("rtglgzzqxnuflitnlyit"), is("rtglgzzqxnuflitnlyti"));
        assertThat(FirstSolution.biggerIsGreater("mhtvaqofxtyrz"), is("mhtvaqofxtyzr"));
        assertThat(FirstSolution.biggerIsGreater("zalqxykemvzzgaka"), is("zalqxykemvzzgkaa"));
        assertThat(FirstSolution.biggerIsGreater("wjjulziszbqqdcpdnhdo"), is("wjjulziszbqqdcpdnhod"));
        assertThat(FirstSolution.biggerIsGreater("japjbvjlxzkgietkm"), is("japjbvjlxzkgietmk"));
        assertThat(FirstSolution.biggerIsGreater("jqczvgqywydkunmjw"), is("jqczvgqywydkunmwj"));

//        assertThat(FirstSolution.biggerIsGreater("ehdegnmorgafrjxvksc"), is("ehdegnmorgafrjxvsck"));
    }
}