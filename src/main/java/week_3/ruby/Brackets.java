package week_3.ruby;

import java.util.Stack;

public class Brackets {
	public int solution(String S) {
		String oBrackets = new String("({[");
		String cBrackets = new String(")}]");
		String hap = oBrackets.concat(cBrackets);
		Stack<Integer> open = new Stack();
		
		int closePos = -1;
		int openPos = -1;
		for (char c : S.toCharArray()) {
			if( hap.indexOf(c) == -1 ) continue;
			
			openPos = oBrackets.indexOf(c);
			if( openPos > -1 ){
				open.push(openPos);
				continue;
			}
			
			closePos = cBrackets.indexOf(c);
			if( closePos > -1 ) {
				if( open.isEmpty() || closePos != open.pop()) return 0;
			}
		}
		
		return open.isEmpty() ? 1 : 0;
	}
	
}
