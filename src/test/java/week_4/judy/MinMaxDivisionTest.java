package week_4.judy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.BeforeClass;
import org.junit.Test;

public class MinMaxDivisionTest {

    static MinMaxDivision  quiz;
    
    @BeforeClass
    public static void setup() {
    	quiz = new MinMaxDivision();
    }

    @Test
    public void earliestJumpLeap(){
    	assertThat(quiz.boards(new int[] {2,1,5,1,2,2,2}, 3), is(6));
    }
}
