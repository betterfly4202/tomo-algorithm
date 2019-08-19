package week_1.ruby;

import java.util.*;

public class MaxProductOfThree {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new int[]{-1,500,-1000,-123,-100}));
	}
}

class Solution1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int len = A.length;
        return A[len - 1] * A[len -2] * A[len -3];
    }
}


class Solution {
    public int solution(int[] A) {
        List<Integer> nagativeArr = new ArrayList<>();
        List<Integer> positiveArr = new ArrayList<>();
        
        int zeroCnt = 0;
        
        for(int i=0; i<A.length; i++) {
            int num = A[i];
            
            if( num < 0 ) {
                nagativeArr.add(num);
            } else if( num > 0 ) {
                positiveArr.add(num);
            } else {
                zeroCnt++;
            }
        }
        
        Collections.sort(nagativeArr);
        Collections.sort(positiveArr);
        
        //System.out.println(nagativeArr);
        //System.out.println(positiveArr);
        
        /***
         * [시나리오]
         * 1. 양수(최대) * 양수(최대) * 양수(최대)
		 * 2. 음수(최소) * 음수(최소) * 양수(최대)
		 * 3. 0
		 * 4. 음수(최대) * 음수(최대) * 음수(최대)
		 * 5. 음수(최대) * 양수(최소) * 양수(최소)
         */
        
        int nagativeCnt = nagativeArr.size();
        int positiveCnt = positiveArr.size();
        int posi1 = 0;
        int posi2 = 0;
        int naga1 = 0;
        int naga2 = 0;
        
        if( nagativeCnt >= 2 && positiveCnt > 0) {
            posi1 = nagativeArr.get(0) * nagativeArr.get(1) * positiveArr.get(positiveCnt -1);
        }
        
        if( positiveCnt >= 3 ) {
            posi2 = positiveArr.get(positiveCnt -1) *
                positiveArr.get(positiveCnt -2) * positiveArr.get(positiveCnt -3);
        } else {
        	if(zeroCnt == 0) {
        		if( nagativeCnt >= 3 )
        			naga1 = nagativeArr.get(nagativeCnt - 1) * nagativeArr.get(nagativeCnt - 2) * nagativeArr.get(nagativeCnt - 3);
        		if( positiveCnt >= 2 && nagativeCnt >=1 )
        			naga2 = positiveArr.get(0) * positiveArr.get(1) * nagativeArr.get(nagativeCnt - 1);
            }
        }
        
        //System.out.println("posi1 => " + posi1 + ", posi2 => " + posi2 + ", naga1 => " + naga1 + ", naga2 => " + naga2);
        //System.out.println("zeroCnt =>" + zeroCnt);
        if ( posi1 > 0 && posi2 > 0 ) {
        	if( posi1 > posi2 ) return posi1;
        	else return posi2;
        } else if ( posi1 == 0 && posi2 > 0 ) {
        	return posi2;
        } else if ( posi2 == 0 && posi1 > 0 ) {
        	return posi1;
        } else if( zeroCnt > 0 ) {
            return 0;
        } else {
        	if( naga1 < 0 && naga2 < 0 ) {
        		if(naga1 > naga2) return naga1;
            	else return naga2;
        	} else {
        		if( naga1 == 0 ) return naga2;
        		else return naga1;
        	}
        }
        
    }
}