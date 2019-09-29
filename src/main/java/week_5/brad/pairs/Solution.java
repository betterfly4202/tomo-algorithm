package week_5.brad.pairs;

import com.sun.tools.javac.util.List;

/**
 * Created by betterfly
 * Date : 2019.09.29
 */
public class Solution {
    /*
        1. sort 해서 큰 값 정렬(DESC) : bubble sort
        2. arr[idx] > K 인 (K보다 큰 값) 루프
        3. arr[idx] - K 의 값이 array에 있는지 2차 검증(loop)또 돌거나, ArrayList로 처리하면 좋음

     */
    static int pairsResult(int[] A, int k){
        sort(A);  // 내림차순 정렬
        int cnt = 0;
        int idx = 0;

        while(idx < A.length-1){
            int temp = A[idx]-k;
            if(List.of(A).contains(temp)){
                cnt++;
            }

            idx++;
        }

        return cnt;
    }

    private static void sort(int[] arr){
        sort(arr, 0 , arr.length- 1);
    }

    private static void sort(int[] arr, int start, int end) {
        int right = partition(arr, start, end);

        if(start < right - 1){
            sort(arr, start, right- 1);
        }

        if(right < end){
            sort(arr, right, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end)/2];

        while(start <= end){
            while(arr[start] > pivot){
                start++;
            }
            while(arr[end] < pivot){
                end --;
            }

            if(start <= end){
                int tmp = arr[end];
                arr[end] = arr[start];
                arr[start] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }

}
