package week_6.judy;

import org.junit.Test;

public class ShortestPathTest {
    static ShortestPath quiz = new ShortestPath();
    
    @Test
    public void TopView숫자들(){
    	//quiz.topView( setNodes(new int[] {1,2,5,3,6,4}) );
//    	quiz.printShortestPath(7, 6, 6, 0, 1);
//    	quiz.printShortestPath(6,5,1,0,5);
    	//quiz.printShortestPath(7,0,3,4,3);
    	//ShortestPath.printShortestPath(150,24,15,46,102); //왜 오답인지 이해가 안감!!! 아.. 우선순위가 있었음.
    	//ShortestPath.printShortestPath(100,2,24,92,45); //왜 오답인지 이해가 안감!!!
    	//ShortestPath.printShortestPath(70,7,15,67,3);
    	ShortestPath.printShortestPath(10,9,9,5,3);
    }
}
