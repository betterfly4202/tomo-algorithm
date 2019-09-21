package week_4.judy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.BeforeClass;
import org.junit.Test;

public class FrogRiverOneTest {

    static FrogRiverOne  quiz;
    
    @BeforeClass
    public static void setup() {
    	quiz = new FrogRiverOne();
    }

    @Test
    public void earliestJumpLeap(){
    	assertThat(quiz.solution( 5, new int[] {1,3,1,4,2,3,5,4}), is(6));
    	assertThat(quiz.solution( 1, new int[] {1}), is(0));
    	assertThat(quiz.solution( 5, new int[] {3}), is(-1));
    }
}
