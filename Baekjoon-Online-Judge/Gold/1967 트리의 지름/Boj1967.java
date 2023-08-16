package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static ArrayList<Tree> tree[];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			tree[i] = new ArrayList<Tree>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[p].add(new Tree(c, e));
			tree[c].add(new Tree(p, e));
		}
		ans = 0;

		for (int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			visit[i] = true;
			dfs(i, 0);
		}
		System.out.println(ans);
	}

	private static void dfs(int cn, int sum) {
		for (Tree tree : tree[cn]) {
			if (!visit[tree.node]) {
				visit[tree.node] = true;
				dfs(tree.node, sum + tree.cost);
			}
		}
		ans = Math.max(ans, sum);
	}
}

class Tree {
	int node;
	int cost;

	public Tree(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}