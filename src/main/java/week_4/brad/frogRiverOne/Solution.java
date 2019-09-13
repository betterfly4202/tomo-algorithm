package week_4.brad.frogRiverOne;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by betterfly
 * Date : 2019.09.15
 * url : https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class Solution {
    /*
    1. 1~X 까지 순차
        - 중복 숫자부터 제거
        - 숫자 순차 검토

        제일 쉬운방법은 계속 반복하면서,
        1~X값(i) 검증해서 순차적으로 있는지 루프를 계속 돌면됨
        -> X : 10_000 인 경우 만번 루프를 돌아야함..최악
     */
    static int earliestTimeIndex(int X, int [] A){

        Map<Integer, Integer> m = valueHouse(A);
        for (int i=1; i<=X; i++){
            if(!m.containsKey(i)){
                return -1;
            }

            if(i == X){
                return m.get(i);
            }
        }
        return -1;
    }

    private static Map<Integer, Integer> valueHouse(int [] A){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<A.length; i++){
            m.put(A[i], i);
//            if(!m.containsKey(A[i])){
//            }
        }

        return m;
    }
}
