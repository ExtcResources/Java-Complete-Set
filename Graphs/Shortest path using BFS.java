import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	static final int EDGE_DISTANCE = 6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			Node[] nodes = new Node[n];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new Node(i);
			}

			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;

				nodes[u].adjacents.add(v);
				nodes[v].adjacents.add(u);
			}

			int s = sc.nextInt() - 1;
			bfs(nodes, s);

			for (int i = 0; i < n; i++) {
                if (i != s) {
                    System.out.print(nodes[i].distance + " ");
                }
            }
            System.out.println();
		}

		sc.close();
	}

	static void bfs(Node[] nodes, int s) {
		Queue<Node> queue = new LinkedList<Node>();
		nodes[s].distance = 0;// root to root distance is zero
		queue.offer(nodes[s]);//similar to queue.add except this doesn't throw any exception
		while (!queue.isEmpty()) {
			Node head = queue.poll();
			for (int adjacent : head.adjacents) {
				if (nodes[adjacent].distance < 0) {
					nodes[adjacent].distance = head.distance + EDGE_DISTANCE;
					queue.offer(nodes[adjacent]);
				}
			}
		}
	}
}

class Node {
	int index;
	List<Integer> adjacents = new ArrayList<Integer>();
	int distance = -1;

	Node(int index) {
		this.index = index;
	}
}
