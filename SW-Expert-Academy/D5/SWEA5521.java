package sw5521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());// 사람 수
			int m = Integer.parseInt(st.nextToken());// 친한 관계 수

			arr = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i <= n; i++) {
				arr.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr.get(a).add(b);
				arr.get(b).add(a);
			}
			cnt = 0;
			
			visited = new boolean[n + 1];
			bfs(1);

			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		visited[num] = true;

		int subCnt = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int now = queue.poll();
				for (int i : arr.get(now)) {
					if (!visited[i]) {
						visited[i] = true;
						queue.add(i);
						cnt++;
					}
				}
			}
			subCnt++;
			if (subCnt == 2)
				break;
		}

	}

}
