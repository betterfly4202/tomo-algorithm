package week_3.brad.brackets;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static week_3.brad.brackets.SolutionArray.bracketEquals;
import static week_3.brad.brackets.SolutionStack.bracketStack;

/**
 * Created by betterfly
 * Date : 2019.09.08
 */
public class SolutionTest {
    String sample = "{[[()()]]}";
    String sample6 = "{[]{[()()]}[]}";
    String sample2 = "([)()]";
    String sample3 = ")(";
    String sample4 = "";

    @Test
    public void 검증(){
        assertThat(bracketEquals(sample), is(1));
        assertThat(bracketEquals(sample6), is(1));
        assertThat(bracketEquals(sample2), is(0));
        assertThat(bracketEquals(sample3), is(0));
        assertThat(bracketEquals(sample4), is(1));
    }

    @Test
    public void 검증_Stack(){
        assertThat(bracketStack(sample), is(1));
        assertThat(bracketStack(sample6), is(1));
        assertThat(bracketStack(sample2), is(0));
        assertThat(bracketStack(sample3), is(0));
        assertThat(bracketStack(sample4), is(1));
    }
}