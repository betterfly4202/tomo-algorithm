package week_2.brad.numberSolitaire;

/**
 * Created by betterfly
 * Date : 2019.09.01
 */
public class Solution {

    public static int dynamicProgramming(int [] arr){
        int [] result = new int [6];

        for (int i = 1; i < arr.length; i++) {
            result[i%6] = getMaxValue(result) + arr[i];
        }

        return arr[0] + result[(arr.length-1)%6];
    }

    private static int getMaxValue(int [] tempArr){
        int max = tempArr[0];
        for (int i = 1; i < tempArr.length; i++) {
            max = Math.max(max, tempArr[i]);
        }
        return max;
    }
}
