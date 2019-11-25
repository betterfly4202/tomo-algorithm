package week_9.judy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgorithm {

	private static int INF = Integer.MAX_VALUE;

	private static class Node implements Comparable<Node> {
		int idx;
		int val;

		int getIdx() {
			return idx;
		}

		int getVal() {
			return val;
		}

		Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			return this.getVal() - o.getVal();
		}
	}

	private static int djikstra(int[][] dist, int n, int src, int dest) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (src != i && dist[src][i] < INF) {
				priorityQueue.offer(new Node(i, dist[src][i]));
			}
		}
		while (!priorityQueue.isEmpty()) {
			Node next = priorityQueue.poll();
			int nidx = next.getIdx();
			int ndist = next.getVal();
			for (int i = 1; i <= n; i++) {
				if (dist[nidx][i] != INF && ndist + dist[nidx][i] < dist[src][i]) {
					dist[src][i] = ndist + dist[nidx][i];
					priorityQueue.offer(new Node(i, dist[src][i]));
				}
			}
		}
		return dist[src][dest];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] dist = new int[1001][1001];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				dist[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int d = scanner.nextInt();
			dist[a][b] = Math.min(dist[a][b], d);
		}
		int src = scanner.nextInt();
		int dest = scanner.nextInt();
		System.out.println(djikstra(dist, n, src, dest));
	}
}