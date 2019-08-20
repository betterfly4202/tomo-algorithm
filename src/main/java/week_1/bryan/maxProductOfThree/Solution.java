import java.util.Arrays;

public class Solution {
    public int solution(int[] target) {
        Arrays.sort(target);

        int idx = target.length-1;
        int normalCase = target[idx] * target[idx-1] * target[idx-2];;
        int specialCase = target[0] * target[1] * target[idx];

        if(normalCase > specialCase)
            return normalCase;
        return specialCase;
    }
}
