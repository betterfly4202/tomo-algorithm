package week_4.brad.minMaxDivision;

/**
 * Created by betterfly
 * Date : 2019.09.15
 * url : https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
 */
public class Solution {
    /*
    - 배열의 길이 N
    - 나눌 배열의 크기 K
    - 배열 내 최대 값 M

    -> K 만큼 나눈 배열 중 최대의 합이 가장 작은 값 찾기
    */

    /*
    접근하기
    1. 배열 전체 덧셈 + 배열내 최대값(M) 을 배열의 공간 K로 나누기 -> 합의 최소값은 M이며, 최대값은 배열 전체 덧셈
    2. 1의 결과를 기준으로 순차적으로 덧셈함. sum <= pivot 까지..
        2-1. 2의 연산결과 sum > pivot 이 되면 그 전까지의 idx까지 하며 K--
        2-2. K값이 0 인데 배열의 공간이 남았으면 pivot++
        2-3. K값이 0보다 크고, 배열 전체를 순회했다면, pivot --
     */
    static int minimumSum(int K, int M, int [] A){
        return pivotValue(K, (getArraySum(A) + M) / K, A);
    }

    static int getArraySum(int [] arr){
        int sum = 0;
        for(int v : arr){
            sum +=v;
        }

        return sum;
    }

    private static int pivotValue(int K, int pivot, int [] A){
        int tempSum= 0;
        int count = 0;

        for(int i=0; i<A.length; i++){
            tempSum += A[i];
            if(count >= K && tempSum>0){
                pivot++;
                pivotValue(K, pivot, A);
            }

            if(tempSum > pivot){
                i -= 1; // 다시 전 단계 계산
                tempSum = 0; // 합 초기화
                count++; // 배열 공간 확인
            }
        }

        return pivot;
    }
}