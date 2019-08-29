package week_2.ruby.maxNonoverlappingSegments;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/
 * 
한 행에 0에서 N-1까지 번호가 매겨진 N 세그먼트가 있으며, 그 위치는 배열 A와 B에 있습니다. 각 I (0 ≤ I <N)에 대해 세그먼트 I의 위치는 A [I]에서 B [ 나] (포함). 세그먼트는 끝을 기준으로 정렬됩니다. 
즉, K에 대한 B [K] ≤ B [K + 1]은 0 ≤ K <N-1입니다.

I ≠ J 인 두 개의 세그먼트 I 및 J는 하나 이상의 공통점을 공유하는 경우 겹칩니다. 즉, A [I] ≤ A [J] ≤ B [I] 또는 A [J] ≤ A [I] ≤ B [J]입니다.

두 개의 겹치는 세그먼트가 포함되어 있지 않으면 세그먼트 세트가 겹치지 않습니다. 목표는 최대 세그먼트 수를 포함하는 겹치지 않는 세트의 크기를 찾는 것입니다.

예를 들어, 배열 A, B를 다음과 같이 고려하십시오.

    A [0] = 1 B [0] = 5
    A [1] = 3 B [1] = 6
    A -[2] = 7 B [2] = 8
    A [3] = 9 B [3] = 9
    A [4] = 9 B [4] = 10
세그먼트는 아래 그림에 표시되어 있습니다.



최대 세그먼트 수를 포함하는 겹치지 않는 세트의 크기는 3입니다. 예를 들어 가능한 세트는 {0, 2, 3}, {0, 2, 4}, {1, 2, 3} 또는 {1, 2, 4}. 네 개의 세그먼트가있는 겹치지 않는 세트가 없습니다.

함수를 작성하십시오.

클래스 솔루션 {public int solution (int [] A, int [] B); }

즉, N 개의 정수로 구성된 두 개의 배열 A와 B가 주어지면 최대 세그먼트 수를 포함하는 겹치지 않는 세트의 크기를 반환합니다.

예를 들어, 위에 표시된 배열 A, B에서 위에서 설명한대로 함수는 3을 반환해야합니다.

다음 가정을위한 효율적인 알고리즘을 작성하십시오.

N은 [0..30,000] 범위 내의 정수이며;
어레이 A, B의 각 요소는 [0..1,000,000,000] 범위 내의 정수이며;
각각의 I에 대해 A [I] ≤ B [I] (0 ≤ I <N);
각 K에 대해 B [K] ≤ B [K + 1] (0 ≤ K <N-1).
 * */
public class Solution {
	
	public int solution(int[] A, int[] B) {
        int startPoint = 0;
        int section = 0;
		for(int i=0; i<A.length; i++) {
    		if(startPoint < A[i]) {
    			section ++;
    			startPoint = B[i];
    		}
        }
        
        return section;
	}
	
	public int solution3_xx(int[] A, int[] B) {
        int[][] map = new int[A.length + 1][B[B.length - 1] + 1];
        int[] temp = new int[B[B.length - 1] + 1];
        int[] newTemp = new int[B[B.length - 1] + 1];
        int depth = 1;
        
        for( int i=A[0]; i<=B[0]; i++) {
    		map[0][i] = 1;
    	}
        
        for( int i=1; i < A.length; i++) {
        	boolean merge = true;
        	
        	for(int j=0; j<depth; j++) {
        		temp = map[j];
        		System.out.println("* tmp[" + j + "] => " + Arrays.toString(temp) + ", A|B =>" +A[i] +"," +  B[i]);
            	
        		Arrays.fill(newTemp, 0);
        		merge = true;
            	for( int k=A[i]; k<=B[i]; k++) {
            		newTemp[k] = i+1;
            		if( temp[k] > 0 ) {
            			merge = false;
            		} else {
            			if( merge ) temp[k] = i+1;
            		}
            	}
            	
            	System.out.println("isMerge =>" + merge + ", arr => " + Arrays.toString(merge? temp:newTemp));
        	}

        	if( merge ) {
    			map[i] = temp;
    		} else {
        		map[i] = newTemp;
    			depth++;
    			//System.out.println("update depth=>" + depth);
        	}
        	
    		//System.out.println("depth => " + depth + "map[" + i + "] => " + Arrays.toString(map[i]));
        }
        
        System.out.println();
        System.out.println();
        for( int i=0; i < A.length; i++) {
        	System.out.println("* map[" + i + "] => " + Arrays.toString(map[i]));
        }
        
		return depth;
    }
	
	public int solution2_xx(int[] A, int[] B) {
        int[][] map = new int[A.length + 1][B[B.length - 1] + 1];
        int[] sum = new int[B[B.length - 1]];
        int depth = 0;
        
        for( int i=0; i<A.length; i++ ) {
        	for( int k=A[i]; k<=B[i]; k++) {
        		map[i][k] = i+1;
        	}
        	
        	System.out.println("map[" + i + "] => " + Arrays.toString(map[i]));
        }
        
        for( int i=1; i<=B[B.length - 1]; i++ ) {
        	sum[i - 1] = map[0][i];
        	for( int k=1; k<A.length; k++) {
        		sum[i - 1] = sum[i - 1] + map[k][i];
        	}
        }
        
        System.out.println("& sum => " + Arrays.toString(sum));
        
        int count = 0;
        for(int i=0; i<sum.length - 1; i++) {
        	if( ( sum[i] == 1 || sum[i+1] == 1) && sum[i] != sum[i+1] ) {
        		count++;
        	}
        }
        
		return count-1;
    }
}
