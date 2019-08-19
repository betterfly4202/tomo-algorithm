package week_1.ruby.oddOccurrencesInArray;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new int[] {0,0,100003,1,2,3,3,2,1,1,1,1,1,1,1,9,9}));
	}
}

class Solution {
    public int solution(int[] A) {
    	Set<Integer> pairSet = new HashSet<Integer>();
    	
    	for( int num : A ) {
    		if( ! pairSet.remove(num) ) {
    			pairSet.add(num);
    		} 
    	}
    	
    	Iterator<Integer> it = pairSet.iterator();
    	
        return it.hasNext() ? it.next() : 0;
    }
}
