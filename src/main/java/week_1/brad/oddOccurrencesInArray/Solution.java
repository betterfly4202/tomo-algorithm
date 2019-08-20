package week_1.brad.oddOccurrencesInArray;

/**
 * Created by betterfly
 * Date : 2019.08.15
 */
public class Solution {

    public static int unpairedValue(int [] arr){
        sort(arr);

        int idx = 0;
        int result = 0;
        while(idx < arr.length-2){
            if(arr[idx] != arr[idx+1]){
                result = arr[idx];
                break;
            }

            idx +=2;
        }

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
