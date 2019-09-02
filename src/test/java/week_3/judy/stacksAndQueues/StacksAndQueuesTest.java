package week_3.judy.stacksAndQueues;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import week_3.judy.StacksAndQueues;

public class StacksAndQueuesTest {

    static StacksAndQueues  sas;
    
    @BeforeClass
    public static void setup() {
    	sas = new StacksAndQueues();
    }

    @Test
    public void 검증(){
    	assertThat( sas.solution(" { [ ( ) ( ) ] } ") , is(1) );
    	assertThat( sas.solution(" ([) ()] ") , is(0) );
    	assertThat( sas.solution(")(") , is(0) );
    	assertThat( sas.solution("{{{{") , is(0) );
    }
}
