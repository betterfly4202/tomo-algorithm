package week_1.brad.oddOccurrencesInArray;

import java.util.Arrays;

/**
 * Created by betterfly
 * Date : 2019.08.20
 */
public class Solution {

    static int unpairedValue(int [] arr){
        sort(arr); // ;
        Arrays.sort(arr);


        int idx = 0;
        int result = 0;
        while(idx < arr.length-2){
            if(arr[idx] != arr[idx+1]){
                result = arr[idx];
                break; // break 를 하는 이유는 idx 이후로는 계속 짝이 안맞기 때문에 최초에 발생한 값이 결과로 판단함
            }
            idx +=2;
        }

        // A의 범위가 1보다 크기 때문에 0보다 작거나 같을 수 없음
        // 따라서 result가 0(초기값) 이라는 것은 모두가 같은 짝을 이루고 있다는 것이고,
        // +2 씩 idx를 검증하기 때문에 검증되지 않은 가장 마지막 값이 결과라는 것.
        if(result == 0){
            result = arr[arr.length-1];
        }

        return result;
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
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
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
