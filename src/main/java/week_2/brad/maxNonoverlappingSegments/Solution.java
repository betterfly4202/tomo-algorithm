package week_2.brad.maxNonoverlappingSegments;

/**
 * Created by betterfly
 * Date : 2019.09.01
 */
public class Solution {

    static int greedyAlgorithm(int []A, int [] B){
        if(A.length < 1){
            return 0;
        }
        int compare = B[0];
        int cnt = 0;
        for (int i = 0; i <A.length ; i++) {
            if(compare <= A[i]){
                compare = B[i];
                cnt++;
            }
        }
        return cnt;
    }
}
