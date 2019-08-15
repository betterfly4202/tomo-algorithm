package week_1.brad.maxProductOfThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.08.14
 */
public class Solution {

    static int maxResult(int [] arr){
        isInvalidateRange(arr);
        Arrays.sort(arr);

        return arr[arr.length- 1] * arr[arr.length- 2] * arr[arr.length- 3];
    }

    private static void isInvalidateRange(int [] arr){
        if(arr.length < 3 || arr.length > 100_000){
            throw new IllegalStateException("Array within the range [3..100,000];");
        }

        for(int v : arr){
            if(v < -1_000 || v > 1_000){
                throw new IllegalArgumentException("Each element of array Value is an integer within the range [−1,000..1,000].");
            }
        }
    }

    public static void main(String[] args) {

    }
}
