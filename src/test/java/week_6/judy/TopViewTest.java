package week_6.judy;

import org.junit.Test;

public class TopViewTest {
    static TopView quiz = new TopView();
    
    @Test
    public void TopView숫자들(){
    	//quiz.topView( setNodes(new int[] {1,2,5,3,6,4}) );
    	quiz.topView( setNodes(new int[] {1,14,3,7,4,5,15,6,13,10,11,2,12,8,9}) );
    	
    }

	private Node setNodes( int[] nums ) {
		Node root = null;
		
		for( int i=0; i<nums.length; i++ ) {
			int data = nums[i];
			root = TopView.insert(root, data);
		}
		return root;
	}
}
