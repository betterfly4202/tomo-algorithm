package week_4.judy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.BeforeClass;
import org.junit.Test;

public class MinMaxDivisionTest {

    static MinMaxDivision  quiz;
    static MinMaxDivision2  quiz2;
    
    @BeforeClass
    public static void setup() {
    	quiz = new MinMaxDivision();
    	quiz2 = new MinMaxDivision2();
    }

    @Test
    public void 첫번째풀이(){
    	assertThat(quiz.boards(new int[] {2,1,5,1,2,2,2}, 3), is(6));
    }
    @Test
    public void 두번째풀이(){
    	assertThat(quiz2.solution(3, 5, new int[] {2,1,5,1,2,2,2} ), is(6));
    	assertThat(quiz2.solution(3, 5, new int[] {5,3} ), is(5));
    	assertThat(quiz2.solution(2, 5, new int[] {5,3} ), is(5));
    }
}
