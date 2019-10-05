package week_6.ruby;

import java.util.*;

import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopView {
	/* 
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	static Map<Integer, Integer> topMap = new HashMap<>();
	static Map<Integer, Integer> depthMap = new HashMap<>();

	public static void topView(Node root) {
		goNext(root, 0, 0);
		print();
    }
	
	private static void print() {
		SortedMap<Integer, Integer> sortMap = new TreeMap<>(topMap);
		Set<Integer> keys = sortMap.keySet();
		Iterator<Integer> it = keys.iterator();
		
		while( it.hasNext() ) {
			Integer key = it.next();
			//System.out.print(key);
			System.out.print(sortMap.get(key));
			if( it.hasNext() ) System.out.print(" ");
		}
	}
	
	private static void goNext(Node root, int index, int depth) {
		if( root == null ) return;

		if( checkSave(index, depth) ) {
			topMap.put(index, root.data);
			depthMap.put(index, depth);
		}
		
		if( root.left != null ) goNext(root.left, index-1, depth+1);
		if( root.right != null ) goNext(root.right, index+1, depth+1);
	}
	
	private static boolean checkSave(int index, int nowDepth) {
		if( ! depthMap.containsKey(index) ) return true;
		return ( depthMap.get(index) > nowDepth ); 
	}
	
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
