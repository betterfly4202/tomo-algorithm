package week_6.brad.topView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by betterfly
 * Date : 2019.10.02
 */
public class Solution {

    /**
     *  1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
     *  -> 2  1  14  15  12
     */

    static Map<Integer, Integer> nodeMap = new LinkedHashMap<>();
    static int beforeNodePoint = 0;

    private static int defaultPoint = 0;

    static void topView(Node root){
        nodeMap.put(defaultPoint, root.data);

        setNodeMapProcedure(root);

        nodeMap.forEach((k, v) -> {
            System.out.print(v+ " ");
        });

    }

    private static void setNodeMapProcedure(Node root){
        System.out.println("Root :" + root.data + " point : " + defaultPoint);

        if(root.left != null){
            defaultPoint --;
            if (!nodeMap.containsKey(defaultPoint)){
                nodeMap.put(defaultPoint, root.left.data);
            }

            setNodeMapProcedure(root.left);
        }else{
            defaultPoint ++;
        }

        if(root.right != null){
            if (!nodeMap.containsKey(defaultPoint)){
                nodeMap.put(defaultPoint, root.right.data);
            }

            setNodeMapProcedure(root.right);
        }
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
