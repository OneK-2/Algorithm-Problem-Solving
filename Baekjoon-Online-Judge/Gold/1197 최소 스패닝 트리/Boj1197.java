package boj1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // a 노드
			int b = Integer.parseInt(st.nextToken()); // b 노드
			int c = Integer.parseInt(st.nextToken()); // 가중치

			pq.add(new Node(a, b, c));
		}

		arr = new int[v + 1];
		for (int i = 0; i < v; i++) {
			arr[i] = i;
		}

		int visit = 0;
		int result = 0;
		while (visit < v - 1) {
			Node now = pq.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				result += now.cost;
				visit++;
			}
		}
		System.out.println(result);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			arr[b] = a;
		}
	}

	private static int find(int a) {
		if (a == arr[a]) {
			return a;
		} else {
			return arr[a] = find(arr[a]);
		}
	}

}

class Node implements Comparable<Node> {
	int start;
	int end;
	int cost;

	public Node(int start, int end, int cost) {
		super();
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}