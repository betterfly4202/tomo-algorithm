package week_8.brad.biggerIsGreater;
/**
 * Created by betterfly
 * Date : 2019.11.03
 */
public class Solution {
    static String biggerIsGreater(String w) {
        int idx = w.length()-1;

        while(idx>0){
           // 바로 앞의 값만 검증해서 뒤에가 앞보다 크면, 그 뒤로만 다시 정렬하면됨
           char currentChar = w.charAt(idx);
           int postCharIdx = idx-1;
           char postChar = w.charAt(postCharIdx);

           // 앞에 문자가 더 작으면 스왑 진행
           if(postChar < currentChar){
               /*
               1 2 3 4
               8 4 6 5
             > 8 5 4 6
               */

               // postChar ~ 전체 문자열 사이 가장 작은 값 찾기
               char tmp = 'z';
               int compareIdx = postCharIdx;
               for(int i=idx; i<w.length(); i++){
                   if(tmp > w.charAt(i)){
                       tmp = w.charAt(i);
                       compareIdx = i;
                   }
               }

               // 변경 후 모든 문자열 ascending sorting..
               String stdValue = swappingCharacter(w, postCharIdx, compareIdx);

               char [] sortingTargetCharArr = orderingAscendingCharacter(stdValue, idx);
               sort(sortingTargetCharArr, 0, w.length()-1 - idx);
               return combinedResult(stdValue, sortingTargetCharArr, idx);
           }

            idx--;
        }

        return "no answer";
    }

    private static String combinedResult(String w, char [] arr, int startIdx){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<startIdx; i++){
            sb.append(w.charAt(i));
        }

        for(int i=0; i<w.length()-startIdx; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static String swappingCharacter(String w, int changeIdx, int moveIdx){
        StringBuilder sb = new StringBuilder(w);
        sb.deleteCharAt(changeIdx);
        sb.insert(changeIdx, w.charAt(moveIdx));

        sb.deleteCharAt(moveIdx);
        sb.insert(moveIdx, w.charAt(changeIdx));

        return sb.toString();
    }

    // 뒤에서부터 검증해서 앞으로 밀면됨.
    private static char[] orderingAscendingCharacter(String w, int startIdx){
        char [] sortedCharArr = new char[w.length() - startIdx];
        int idx = 0;
        for(int i=startIdx; i<w.length(); i++){
            sortedCharArr[idx] = w.charAt(i);
            idx++;
        }

        return sortedCharArr;
    }

    private static void sort(char[] arr, int start, int end){
        int right = partition(arr, start, end);

        if(start < right - 1){
            sort(arr, start, right- 1);
        }

        if(right < end){
            sort(arr, right, end);
        }
    }

    private static int partition(char[] arr, int start, int end) {
        int pivot = arr[(start +end) / 2];

        while(start <= end){
            while(arr[start] < pivot){
                start ++;
            }

            while(arr[end] > pivot){
                end --;
            }

            if(start <= end){
                char tmp = arr[end];
                arr[end] = arr[start];
                arr[start] = tmp;

                start ++;
                end --;
            }
        }

        return start;
    }

}
