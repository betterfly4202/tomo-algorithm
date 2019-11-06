package week_8.brad.biggerIsGreater;

/**
 * Created by betterfly
 * Date : 2019.11.05
 */
public class FirstSolution {
    static String biggerIsGreater(String w) {
        for(int i=w.length()-1;  i>0; i--){
            Character c = w.charAt(i);
            for(int j=i-1; j>=0; j--){
                if(c > w.charAt(j)){
                    String result = switchingCharacter(w, i, j);
                    return resortedCharacter(result, j+1);
                }
            }
        }
        return "no answer";
    }

    // 1차 정렬
    public static String switchingCharacter(String w, int i, int j){
        StringBuilder sb = new StringBuilder(w);
        sb.deleteCharAt(i);
        sb.insert(j, w.charAt(i));
        return sb.toString();
    }

    // 2차 정렬 > index 뒤로 제일 작은 값을 앞으로 뺴기
    public static String resortedCharacter(String w, int idx){
        for(int i = w.length()-1; i>idx; i--){
            Character c = w.charAt(i);
            for(int j=idx; j<i; j++){
                if(c < w.charAt(j)){
                    return switchingCharacter(w, i, j);
                }
            }
        }

        return w;
    }
}
