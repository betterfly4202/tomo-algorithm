package week_8.brad.biggerIsGreater;
/**
 * Created by betterfly
 * Date : 2019.11.03
 */
public class Solution {
    static String biggerIsGreater(String w) {
        for(int i=w.length()-1;  i>0; i--){
            Character c = w.charAt(i);
            for(int j=i-1; j>=0; j--){
                if(c > w.charAt(j)){
                    return switchingCharacter(w, i, j);
                }
            }
        }
        return "no answer";
    }

    public static String switchingCharacter(String w, int i, int j){
        StringBuilder sb = new StringBuilder(w);
        sb.deleteCharAt(i);
        sb.insert(j, w.charAt(i));
        return sb.toString();
    }
}
