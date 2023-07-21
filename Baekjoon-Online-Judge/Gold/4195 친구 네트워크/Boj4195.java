package boj4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//유니온 파인드
public class Main {
	static int[] parent;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int f = Integer.parseInt(br.readLine());
			parent = new int[f * 2];
			count = new int[f * 2];
			for (int j = 0; j < f * 2; j++) {
				parent[j] = j;
				count[j] = 1;
			}

			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int index = 0;
			for (int j = 0; j < f; j++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String e = st.nextToken();

				if (!map.containsKey(s)) {
					map.put(s, index++);
				}
				if (!map.containsKey(e)) {
					map.put(e, index++);
				}

				sb.append(union(map.get(s), map.get(e)) + "\n");
			}

		}
		System.out.println(sb);

	}

	private static int union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
			count[x] += count[y];

			// count[y] = 1;
		}

		return count[x];
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

}
