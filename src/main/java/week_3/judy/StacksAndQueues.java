package week_3.judy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 */
public class StacksAndQueues {
	//test coverage : 100%,  time complex : O(N)
    public int solution(String S) {
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	map.put(')', '(');
    	map.put('}', '{');
    	map.put(']', '[');
    	
    	LinkedList<Character> openchar = new LinkedList<Character>();
    	for( int i=0; i<S.length(); i++ ) {
    		char c = S.charAt(i);
    		if( map.containsValue(c) ) {
    			openchar.push(c);
    		}else if( map.containsKey(c) ) {
    			if( map.get(c) != openchar.poll() ) {
    				return 0;
    			}
    		}
    	}
    	
    	if( openchar.size() > 0 )
    		return 0;
    	
    	return 1;
    }
    
	//corretness : 33%, performance : 40%
    public int solution2(String S) {
    	char[] middlable = new char[] {'W','T','Y','U','I','O','A','H','X','V','M',' '};
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	map.put('(', ')');
    	map.put(')', '(');
    	map.put('}', '{');
    	map.put('{', '}');
    	map.put('[', ']');
    	map.put(']', '[');
    	map.put('\'', '\'');

    	S = S.replaceAll(" ", "");
    	
    	int half = (int) S.length()/2;
    	int remains = S.length()%2;
    	
    	if( remains == 1 ) {
    		char middle = S.charAt(half+1);
    		if( Arrays.asList(middlable).indexOf(middle) == 0 )
    			return 0;
    	}
    	
    	LinkedList<Character> queue = new LinkedList<Character>();
    	for( int i=0; i<half; i++ ) {
    		queue.push(S.charAt(i));
    	}
    	
    	for( int i=half+remains ; i<S.length(); i++ ) {
    		if( S.charAt(i) != map.get(queue.poll()) )
    			return 0;
    	}
    	
    	return 1;
    }
}
