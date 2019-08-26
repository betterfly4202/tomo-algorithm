
package week_2.ruby.numberSolitaire;

/**
 * https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
 * 
1인용 게임은 0부터 N - 1까지 번호가 매겨진 N연속 사각형으로 구성된 보드에서 진행된다. 
각 광장마다 숫자가 적혀 있다. N 정수의 비어 있지 않은 배열 A는 정사각형에 쓰여진 숫자를 포함한다. 
게다가, 일부 사각형은 경기 중에 표시될 수 있다.
경기 시작 시, 0번 정사각형 위에 조약돌이 있고, 이 정사각형은 보드 위에 유일하게 표시되어 있다. 게임의 목표는 자갈을 N - 1 제곱으로 옮기는 것이다.

각 턴에서 우리는 얼굴에 1부터 6까지의 숫자를 가진 6면 다이(Die)를 던지며, 다이(Die)가 정지된 후 윗면에 나타나는 K(K) 숫자를 고려한다. 
그런 다음 제곱 번호 I + K가 존재한다면 제곱 번호 I + K에 서 있는 조약돌을 제곱 번호 I + K로 이동시킨다. 
제곱수 I + K가 존재하지 않으면 유효한 움직임을 얻을 때까지 다시 주사위를 던진다. 마지막으로, 우리는 제곱수 I + K를 표시한다.

경기가 끝나면(제곱 넘버 N - 1에 조약돌이 서 있을 때), 결과를 계산한다. 경기의 결과는 표시된 모든 정사각형에 쓰여진 숫자의 합이다.

예를 들어, 다음과 같은 배열로 볼 수 있다.

A[0] = 1
A[1] = -2
A[2] = 0
A[3] = 9
A[4] = -1
A[5] = -2
하나의 가능한 게임은 다음과 같을 수 있다.

조약돌은 정사각형 번호 0에 표시된다.
우리는 3을 던진다; 조약돌은 0에서 3으로 이동한다; 우리는 3을 표시한다.
우리는 5를 던진다. 그 조약돌은 움직이지 않는다. 왜냐하면 널빤지에는 8이 정사각형이 없기 때문이다.
우리는 2를 던진다; 조약돌은 5로 이동한다; 우리는 이 정사각형을 표시하고 게임은 끝난다.
표시된 정사각형은 0, 3, 5이므로 경기 결과는 1 + 9 + (-) = 8이다. 이것은 이 보드에서 얻을 수 있는 최대 가능한 결과다.

함수 쓰기:

class Solution { public int 솔루션(int[] A), }

즉, N 정수의 비어 있지 않은 배열 A가 주어지면 배열 A로 대표되는 보드에서 달성할 수 있는 최대 결과를 반환한다.

예를 들어, 어레이가

A[0] = 1
A[1] = -2
A[2] = 0
A[3] = 9
A[4] = -1
A[5] = -2
함수는 위에서 설명한 대로 8을 반환해야 한다.

다음과 같은 가정에 대해 효율적인 알고리즘을 작성하십시오.

N은 범위[2] 내의 정수이다.100,000];
배열 A의 각 요소는 범위[10,000] 내의 정수임10,000].
 * */
public class Solution {
	public int solution(int[] A) {
        int result = A[0];
        int length = A.length;
        boolean isMax = false;
        for(int i=0; i<length; i++) {
        	
        	int dice = 1;
        	isMax = false;
        	
        	for(int k=1; k<=6; k++) {
        		dice = i + k;
        		//System.out.println("i -> " + i + ", k -> " + k);
        		if( dice >= length ) break;
        		if( A[i] < ( A[i] + A[dice] ) ) {
        			isMax = true;
        			result += A[dice];
        			break;
        		}
        	}
        	i = dice;
        	//System.out.println("position -> " + i + ", result -> " + result);
        	
        	if( !isMax ) {
        		result += A[dice - 1];
        	}
        }
        
		return result;
    }
}
