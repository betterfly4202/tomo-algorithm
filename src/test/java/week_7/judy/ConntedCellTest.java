package week_7.judy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class ConntedCellTest {
    @Test
    public void 연속된_면적구하기(){
    	assertThat( ConnectedCells.connectedCell(
    			new int[][]{
    				{1,1,0,0},
    				{0,1,1,0},
    				{0,0,1,0},
    				{1,0,0,0}})
    			, is(5) );

    	assertThat( ConnectedCells.connectedCell(
    			new int[][]{
    				{0,1,1,1,1},
    				{1,0,0,0,1},
    				{1,1,0,1,0},
    				{0,1,0,1,1},
    				{0,1,1,1,0}})
    			, is(15) );
    }
}
