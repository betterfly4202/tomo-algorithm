package week_4.judy;

/**
14.3. Binary search on the result
 In many tasks, we should return some integer that is both optimal and that meets certain
conditions. We can often find this number using a binary search. We guess some value and
then check whether the result should be smaller or bigger. At the start we have a certain
range in which we can find the result. After each attempt the range is halved, so the number
of questions can be estimated by O(log n).
Thus, the problem of finding the optimal value reduces to checking whether some value
is valid and optimal. The latter problem is often much simpler, and the binary search adds
only a log n factor to the overall time complexity.

14.4. Exercise
[Problem]
 You are given n binary values x0, x1, . . . , xn−1, such that xi ∈ {0, 1}. This array
represents holes in a roof (1 is a hole). You are also given k boards of the same size. The goal
is to choose the optimal (minimal) size of the boards that allows all the holes to be covered
by boards.

[Solution]
 The size of the boards can be found with a binary search. If size x is sufficient to
cover all the holes, then we know that sizes x+ 1, x+ 2, . . . , n are also sufficient. On the other
hand, if we know that x is not sufficient to cover all the holes, then sizes x − 1, x − 2, . . . , 1
are also insufficient.

source : https://codility.com/media/train/12-BinarySearch.pdf
 */

public class BinarySearchExample {
	public static void main(String[] args) {
		BinarySearchExample s = new BinarySearchExample();
		System.out.println( s.boards(new int[] {1,1,1,0,0,1,1,1,1,1,0,0,0,0,0,1}, 8) );
	}

	// param  : 
	//     A = 구멍을 가진 배열, 
	//     k = 구멍을 가리는 board의 갯수 (board_count의 최댓값)
	// return : board의 크기 (k개의 board로 구멍을 가릴 수 있는 최소 크기)
	
	public int boards( int[] A, int k ) { 
		int n = A.length;
		int beg = 1; //결과값 범위의 최소값 (board의 크기는 0보다 크다)
		int end = n; //결과값 범위의 최댓값 (board의 크기는 A length를 넘어설 수 없다)
		int result = -1;
		int mid=-1;
		
		while( beg <= end ) {
			mid = (beg+end)/2; //중간 값을 먼저 확인함.
			
			if( getBoardCount(A,mid) <= k ) { 
				//board count값이 기준점(board갯수)보다 작거나 같으면 board사이즈를 더 작게 만들어서 확인이 필요하다. 
				//이 범위안에서  board count가 k와 같은 경우에는 정답이 될 수도 있다.
				//작은 값들을 확인해야 하므로 mid값 이상인 값들은 버린다.
				// [o][o][o][o][ x ][x][x][x][x]
				// [0][1][2][3][mid][5][6][7][8]
				
				end = mid - 1;
				result = mid;
			}else {
				//board count값이 기준점(board갯수)보다 크다면 board사이즈를 더 크게 만들어서 확인이 필요함.
				//mid이하의 값들은 버린다.
				// [x][x][x][x][ x ][o][o][o][o]
				// [0][1][2][3][mid][5][6][7][8]
				
				beg = mid + 1;
			}
		}
		return result;
	}

	//board_size로 가릴 수 있는 hole의 갯수
	private int getBoardCount(int[] A, int board_size) {
		int n= A.length;
		int board_count = 0;
		int last = -1;
		
		for( int i=0; i<n; i++ ) {
			if( A[i]==1 && last < i ) { // 새로운 구멍이 발견되었고, board로 덮여있지않다고 판단되는 경우에만 통과시키는 조건문.
				board_count += 1;
				last = i+board_size-1; //board가 겹치지 않는 것을 판단하기 위한 변수. 이전의 board가 끝나는 index를 가진 변수.
			}
		}
		return board_count;
	}
	
}
