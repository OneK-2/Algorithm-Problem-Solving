package boj1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] city;
	static int[] plan;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		city = new int[n + 1][n + 1];
		plan = new int[m + 1];
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		// 도시 정보
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 여행 계획
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (city[i][j] == 1) {
					union(i, j);
				}
			}
		}
		int index = find(plan[1]);
		for (int i = 2; i < plan.length; i++) {
			if (index != find(plan[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void union(int i, int j) {
		i = find(i);
		j = find(j);

		if (i != j) {
			arr[j] = i;
		}
	}

	private static int find(int i) {
		if (i == arr[i]) {
			return i;
		} else
			return arr[i] = find(arr[i]);
	}

}
