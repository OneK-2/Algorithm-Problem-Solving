package sw1232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Node {
		int value; // 노드값
		char opr;// 노드 연산자
		int left, right;// 자식노드번호

		public Node(int value, char opr, int left, int right) {
			super();
			this.value = value;
			this.opr = opr;
			this.left = left;
			this.right = right;
		}

		public Node(int value) {
			this.value = value;
		}

	}

	static Node[] nodes;

	private static int calc(Node node) {
		// 연산자 추출
		char opr = node.opr;
		if (opr == '-') {
			return calc(nodes[node.left]) - calc(nodes[node.right]);
		} else if (opr == '+') {
			return calc(nodes[node.left]) + calc(nodes[node.right]);
		} else if (opr == '*') {
			return calc(nodes[node.left]) * calc(nodes[node.right]);
		} else if (opr == '/') {
			return calc(nodes[node.left]) / calc(nodes[node.right]);
		} else {
			return node.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			nodes = new Node[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				if (st.countTokens() == 4) {
					st.nextToken();
					char c = st.nextToken().charAt(0);
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					nodes[i] = new Node(i, c, left, right);
				} else {
					st.nextToken();
					nodes[i] = new Node(Integer.parseInt(st.nextToken()));
				}

			}

			int answer = calc(nodes[1]);
			System.out.println("#" + test_case + " " + answer);
		}

	}

}
