package week_8.judy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BiggerIsGreater {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
 
        int[] arr = new int[w.length()];
 
        for(int i=0; i<w.length(); i++){
            arr[i] = w.charAt(i);
        }
        String rs = "";
        if(nextPermutation(arr)){
            for(int n : arr){
                rs += (char)n;
            }
            return rs;
        } else {
            return "no answer";
        }
    }
 
    static boolean nextPermutation(int[] array) {
        
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
       
        if (i <= 0) {
            return false;
        }
        
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }
 
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;
        
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        
        return true;
    }
	/*
    // Complete the biggerIsGreater function below.
    public static String biggerIsGreater(String w) {
    	char[] words = w.toCharArray();
    	for( int i=0; i<words.length-1; i++ ) {
    		if( sortWords( words , i+1 ) )
    			break;
    	}
    	String result = String.copyValueOf(words);
    	return result.equals(w) ? "no answer" : result;
    }

    private static boolean sortWords(char[] words, int range) {

		System.out.println(String.copyValueOf(words));
    	boolean already_switch = false;
    	boolean sorted = false;
    	for( int i=words.length-range-1; i<words.length-1 ; i++ ) {
    		for( int j=i+1; j<words.length; j++ ) {
				//System.out.println(String.copyValueOf(words));
    			if( ! already_switch ) {
        			if( words[i] < words[j] ) {
        				char tmp = words[i];
        				words[i] = words[j];
        				words[j] = tmp;
        				already_switch = true;
        				sorted = true;
        			}
    			}else {
        			if( words[i] > words[j] ) {
        				char tmp = words[i];
        				words[i] = words[j];
        				words[j] = tmp;
        			}
    			}
				//System.out.print(i+"<->"+j+" "+already_switch+" : ");
				//System.out.println(String.copyValueOf(words));
    		}
    	}
    	return sorted;
	}
*/
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
