package week_6.bard.topView;

import java.util.*;

/**
 * Created by betterfly
 * Date : 2019.10.02
 */
public class SolutionByQueue {
    /**
     *  1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
     *  -> 2  1  14  15  12
     */
    static class nodeQueue{
        Node node;
        int position;

        public nodeQueue(Node node, int position){
            this.node = node;
            this.position = position;
        }
    }

    private static Queue<nodeQueue> queue = new LinkedList<>();
    private static TreeMap<Integer, Integer> map = new TreeMap<>();

    private static void topView(Node root){
        queue.add(new nodeQueue(root, 0));
        process();
        print();
    }

    private static void process(){
        while(!queue.isEmpty()){
            nodeQueue q = queue.poll();
            if(!map.containsKey(q.position)){
                map.put(q.position, q.node.data);
            }

            if(q.node.left != null){
                addQueue(q.node.left, q.position - 1);
            }
            if(q.node.right != null){
                addQueue(q.node.right, q.position + 1);
            }
        }
    }
    
    private static void addQueue(Node n, int position){
        queue.add(new nodeQueue(n, position));
    }

    private static void print(){
        map.values().forEach(v ->{
            System.out.print(v + " ");
        });
    }

    static class Node{
        Node(int data){
            this.data = data;
        }

        int data;
        Node left;
        Node right;
    }

    private static Node insert(Node root, int data) {
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
