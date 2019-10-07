package week_6.bard.topView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by betterfly
 * Date : 2019.10.02
 */
public class Solution {
    static Map<Integer, Integer> nodeMap = new HashMap<>();
    private static int defaultPoint = 500;

    static void topView(Node root){
        nodeMap.put(defaultPoint, root.data);

        setNodeMapProcedure(root);

        nodeMap.forEach((k, v) -> {
            System.out.print(k + " ");
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
        }

        if(root.right != null){
            defaultPoint ++;
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
