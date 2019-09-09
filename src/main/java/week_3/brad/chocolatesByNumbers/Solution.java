package week_3.brad.chocolatesByNumbers;

/**
 * Created by betterfly
 * Date : 2019.09.08
 */


/*
    [ 유클리드 호제법 ]
    a, b, q ,r 이 정수 일 때
    a = b * q + r -> gcd(a,b) = gcd(b,r)

    O(log(N + M))
 */
public class Solution {
    static int eatingCount(int N, int M){
        int gcd = getGreatestCommonDivisor(N, M);

        return N / gcd;
    }

    private static int getGreatestCommonDivisor(int N, int M){
        while(M > 0){
            int tmp = M;
            M = N % M;
            N = tmp;
        }

        return N;
    }
}