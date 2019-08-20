package week_1.brad.maxProductOfThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.08.14
 */
public class Solution {

    private final static List<Integer> list = new ArrayList<>();
    private static int minusCount = 0;

    static int maxResult(int [] arr){
        Arrays.sort(arr);
        isInvalidateRange(arr);

        int result = arr[arr.length- 1] * arr[arr.length- 2] * arr[arr.length- 3];
        if(minusCount%2 == 0){
            int minus = arr[0] * arr[1] * arr[arr.length-1];
            if(minus - result >0){
                result = minus;
            }
        }

        return result;
    }

    private static void isInvalidateRange(int [] arr){
        if(arr.length < 3 || arr.length > 100_000){
            throw new IllegalStateException("Array within the range [3..100,000];");
        }

        for(int v : arr){
            if(v < -1_000 || v > 1_000){
                throw new IllegalArgumentException("Each element of array Value is an integer within the range [−1,000..1,000].");
            }

            if(v < 0){
                minusCount++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
