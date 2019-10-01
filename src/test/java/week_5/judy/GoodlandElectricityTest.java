package week_5.judy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

public class GoodlandElectricityTest {

    @Test
    public void k만큼_떨어져있는_숫자쌍_개수(){
    	assertThat(GoodlandElectricity.pylons( 2 , new int[] {0,1,1,1,1,0} ), is(2));
    	assertThat(GoodlandElectricity.pylons( 2 , new int[] {0,1,0,0,0,1,0} ), is(-1));
    	assertThat(GoodlandElectricity.pylons( 3 , new int[] {0,1,0,0,0,1,1,1,1,1} ), is(3));
    	
    	//wrong answer
    	assertThat(GoodlandElectricity.pylons( 20 , new int[] {0,0,1,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,1,1,0,0,0,0,1,0,0,0,0} ),
    											is(3));
    	
    	int [] testarr = readTestCase("C:\\Users\\ckdbw\\Documents\\tomo-algorithm\\src\\test\\java\\week_5\\judy\\testcase.txt");
    	assertThat(GoodlandElectricity.pylons( 4 , testarr ),is(17901));
    }
    
    private int[] readTestCase( String testfile ) {
    	try(FileReader fr = new FileReader(testfile);
    		BufferedReader reader = new BufferedReader(fr) ){
    		int[] arr = new int[100000];
    		String line = null;
    		
    		int linenum=0;
			while( (line = reader.readLine()) != null ) {
				String[] split = line.split(",");
				for( int i=0; i<split.length; i++ ) {
					arr[linenum*60+i] = Integer.parseInt(split[i]);
				}
				linenum++;
			}
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
}
