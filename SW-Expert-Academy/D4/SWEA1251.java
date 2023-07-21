package sw1251;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소신장트리
public class Solution {
	static double e;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			int n = Integer.parseInt(br.readLine());
			Node[] island = new Node[n];

			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
			// x좌표입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				island[i] = new Node(Integer.parseInt(st.nextToken()), 0, 0);
			}
			// y좌표입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				island[i].y = Integer.parseInt(st.nextToken());
			}
			// 환경부담세율
			e = Double.parseDouble(br.readLine());

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					double len = cirLen(island[i].x, island[i].y, island[j].x, island[j].y);
					pq.add(new Node(i, j, len));
				}
			}
			
			double result = 0;
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (find(now.x) != find(now.y)) {

					union(now.x, now.y);
					result += now.cost;
				}

			}

			System.out.println("#" + test_case + " " + Math.round(result));
		}
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
		}
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}

	// 환경 부담금 -> E * L^2. 부동소수점 고려하여 e는 결과값에 곱함
	private static double cirLen(int x, int y, int x2, int y2) {
		return e * Math.pow((Math.sqrt(Math.pow(x2 - x, 2) + (Math.pow(y2 - y, 2)))), 2);
	}

}

class Node implements Comparable<Node> {
	int x;
	int y;
	double cost;

	public Node(int x, int y, double cost) {
		super();
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		if (this.cost > o.cost)
			return 1;
		else
			return -1;
	}
}