package week_1.bryan.oddOccurrencesInArray;
import java.util.Arrays;

public class Solution {
    public int solution(int[] target) {
        Arrays.sort(target);
        int aloneNumber = -1;
        for(int number : target){
            if(aloneNumber == -1){
                aloneNumber = number;
                continue;
            }
            
            if(aloneNumber == number)
                aloneNumber = -1;
            else
                return aloneNumber;
        }
        return aloneNumber;
    }
}
