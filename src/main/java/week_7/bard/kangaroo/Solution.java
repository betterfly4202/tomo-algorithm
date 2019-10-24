package week_7.bard.kangaroo;

/**
 * Created by betterfly
 * Date : 2019.10.23
 */
public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2){
        if(!validation(v1, v2)){
            return "NO";
        }

        int oneSum = x1+v1;
        int twoSum = x2+v2;

        // X, V 최대 값 : 10,000
        int limit = 10_000;

        if (oneSum == twoSum)
            return "YES";

        while(oneSum < twoSum){
            oneSum += v1;
            twoSum += v2;

            if (oneSum == twoSum)
                return "YES";

            if(oneSum > (limit*limit + limit))
                return "NO";
        }

        return "NO";
    }

    private static boolean validation(int v1, int v2){
        // x1 < x2 조건
        if(v1 <= v2){
            return false;
        }

        return true;
    }

    private static int gcd(int x, int y){
        while(y > 0){
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }

    static int lcm(int x, int y){
        return (x * y) / gcd(x ,y);
    }
}
