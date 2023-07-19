package boj1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		int m = Integer.parseInt(st.nextToken()); // 신뢰 관계 수
		arr = new ArrayList<>();
		ans = new int[n + 1];

		for (int i = 0; i <= n; i++) { // 초기화
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b); // a가 b를 신뢰
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			Bfs(i);
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, ans[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (max == ans[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}

	private static void Bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : arr.get(now)) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					ans[i]++;
				}
			}
		}

	}
}
