package week_3.brad.brackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by betterfly
 * Date : 2019.09.10
 */
public class SolutionStack {
    static int bracketStack(String S){
        if(S.equals("")){
            return 1;
        }
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if (charMap.containsKey(c)) {
                stack.push(charMap.get(c));
            }else{
                if(!stack.isEmpty()
                    && c ==stack.peek()) {
                    stack.pop();
                }else{
                    return 0;
                }
            }
        }

        return 1;
    }
}
