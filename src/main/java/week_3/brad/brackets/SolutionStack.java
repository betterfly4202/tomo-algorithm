package week_3.brad.brackets;

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

        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return 0;
                }
                char temp = stack.pop();
                if(c == '}' && temp != '{'){
                    return 0;
                }
                if(c == ']' && temp != '['){
                    return 0;
                }
                if(c == ')' && temp != '('){
                    return 0;
                }
            }
        }

        return 1;
    }
}
