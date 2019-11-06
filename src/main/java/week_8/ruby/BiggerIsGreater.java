package week_8.ruby;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BiggerIsGreater {
	// Complete the biggerIsGreater function below.
    public static String biggerIsGreater(String w) {
    	char[] charsw = w.toCharArray();
    	
    	if(isNoAnswer(charsw)) return "no answer";
    	
    	String nextWord = getLexicographicalNextWord(charsw);
    	
    	return nextWord != null ? nextWord : "no answer";
    }
    
    private static boolean isNoAnswer(char[] charsw) {
    	if(charsw.length < 2) return true;
    	
    	char[] sameChars = new char[charsw.length];
    	Arrays.fill(sameChars, charsw[0]);
    	return Arrays.equals(charsw, sameChars);
    }
    
    public static String getLexicographicalNextWord(char[] chars) {
    	int length = chars.length;
    	String strChars = String.valueOf(chars);
    	
    	List<String> combiWords = getCombination(Arrays.copyOf(chars, length), length);
    	Collections.sort(combiWords);
    	
    	int findPos = combiWords.lastIndexOf(strChars);
    	if( findPos < 0 ) return null;
    	
		return ( strChars.equals(combiWords.get(findPos)) && !strChars.equals(combiWords.get(combiWords.size()-1))) ?
			combiWords.get(findPos+1) : null;
    }
    
    //문자열의 길이가 길어질 수록.... 경우의 수가 많아진다.
    public static List<String> getCombination(char[] tmpChars, int N) {
    	List<String> combinations = new ArrayList<>();
    	
    	if( N == 1) {
    		combinations.add(String.valueOf(tmpChars));
    		return combinations;
    	}
    	
    	for(int i=0; i<N; i++) {
    		swap(tmpChars, i, N-1);
    		combinations.addAll(getCombination(tmpChars, N-1));
    		swap(tmpChars, i, N-1);
    	}
    	
    	return combinations;
    }
    
    private static void swap(char[] chars, int i, int j) {
    	char tmp;
    	if( i == j ) return;
    	
    	tmp = chars[i];
    	chars[i] = chars[j];
    	chars[j] = tmp;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
