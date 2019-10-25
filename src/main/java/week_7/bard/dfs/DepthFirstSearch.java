package week_7.bard.dfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by betterfly
 * Date : 2019.10.25
 */
public class DepthFirstSearch {
    static class Graph{
        static class Node{
            int data;
            boolean marked;
            LinkedList<Node> adjacent;

            Node(int data){
                this.data = data;
                this.marked = false;
                adjacent = new LinkedList<Node>();
            }
        }

        Node[] nodes;
        Graph(int size){
            nodes = new Node[size];

            for(int i=0; i<size; i++){
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2){
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if(!n1.adjacent.contains(n2)){
                n1.adjacent.add(n2);
            }

            if(!n2.adjacent.contains(n1)){
                n2.adjacent.add(n1);
            }
        }

        void dfs(){
            dfs(0);
        }

        void dfs(int idx) {
            Node root = nodes[idx];
            Stack<Node> stack = new Stack<Node>();

            stack.push(root);
            root.marked = true;
            while(!stack.isEmpty()){
                Node r = stack.pop();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        stack.push(n);
                    }
                }

                visit(r);
            }
        }

        void bfs(){
            bfs(0);
        }

        void bfs(int idx){
            Node root = nodes[idx];
            Queue<Node> queue = new PriorityQueue<>();
            queue.offer(root);
            root.marked = true;

            while(!queue.isEmpty()){
                Node r = queue.peek();
                for(Node n : r.adjacent){
                    if(n.marked == false){
                        n.marked = true;
                        queue.offer(n);
                    }
                }

                visit(r);
            }
        }

        // recursive dfs
        void dfsR(Node r){
            if(r == null) return;

            r.marked = true;
            visit(r);
            for(Node n : r.adjacent){
                if(n.marked == false){
                    dfsR(n);
                }
            }
        }

        void dfsR(){
            dfsR(0);
        }

        void dfsR(int idx){
            Node r = nodes[idx];
            dfsR(r);
        }

        void visit(Node n){
            System.out.print(n.data + " ");
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(0 ,1);
        g.addEdge(1 ,2);
        g.addEdge(1 ,3);
        g.addEdge(2 ,4);
        g.addEdge(2 ,3);
        g.addEdge(3 ,4);
        g.addEdge(3 ,5);
        g.addEdge(5 ,6);
        g.addEdge(5 ,7);
        g.addEdge(6 ,8);

        g.dfs();
        g.bfs();
        g.dfsR(3);

    }
}
