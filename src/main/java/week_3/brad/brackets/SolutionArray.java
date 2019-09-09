package week_3.brad.brackets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by betterfly
 * Date : 2019.09.08
 *
 * todo
 * - 왼쪽이 무조건 열고, 오른쪽에서 닫는게 있으면됨
 */
public class SolutionArray {
    public static int bracketEquals(String S){
        if(S.equals("")){
            return 1;
        }

        List<Character> arrList = new ArrayList<>();

        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c=='(' ||  c=='{' || c=='['){
                arrList.add(c);
            }else{
                if(c==')' && arrList.contains('(')){
                    arrList.remove(arrList.indexOf('('));
                }else if(c=='}' && arrList.contains('{')){
                    arrList.remove(arrList.indexOf('{'));
                }else if(c==']' && arrList.contains('[')){
                    arrList.remove(arrList.indexOf('['));
                }else{
                    return 0;
                }
            }
        }

        if(arrList.isEmpty()){
            return 1;
        }

        return 0;
    }
}
