package week_6.judy;

/**
 * https://www.hackerrank.com/challenges/tree-top-view/problem
 */

import java.util.*;

import javax.swing.event.ListSelectionEvent;

import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    int horizon_depth;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TopView {
	static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	
	public static void topView(Node root) {
		if( root == null ) {
			return;
		}
		
		preorder( root , 0 );
		
		int[] keys = new int[m.size()];
		int i=0;
		for( Integer key : m.keySet() ) {
			keys[i++]=key;
		}
		
		Arrays.sort( keys );
		
		for( int j=0; j<keys.length; j++ ) {
			System.out.print( m.get(keys[j]) );
			if( j != keys.length-1 ) {
				System.out.print(" ");
			}
		}
		System.out.println();
    }

	private static void preorder(Node root, int horizon_depth) {
        if(root==null)
        	return;
        
        System.out.println(",horizon_depth="+horizon_depth+", data="+root.data);
        
        if( ! m.containsKey(horizon_depth) )
        	m.put(horizon_depth, root.data);
        
        preorder(root.left, horizon_depth-1);
        preorder(root.right, horizon_depth+1);
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
