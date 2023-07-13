package boj9742;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[] arr; // 입력배열
	static String[] result; // 최종 결과값 저장
	static String[] tmp; // 순열 결과값 임시 저장
	static String s; // 입력 문자열
	static boolean visited[]; // 방문여부
	static int count, m; // count는 순열 연산 횟수, m은 찾아야 하는 위치

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line = null;
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			s = st.nextToken(); // 입력 문자열
			m = Integer.parseInt(st.nextToken()); // 찾아야 하는 위치
			arr = new String[s.length()];
			visited = new boolean[s.length()];
			tmp = new String[s.length()];
			result = new String[s.length()];
			count = 0;
			// 배열에 값 저장
			arr = s.split("");

			recur(0); // 깊이 0

			printResult();

		}
	}

	private static void recur(int depth) {
		// 종료조건
		if (depth == arr.length) {
			count++;
			if (count == m) {
				for (int i = 0; i < arr.length; i++) {
					result[i] = tmp[i];
				}
			}
			return;
		}
		// 처리조건
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				tmp[depth] = arr[i];
				visited[i] = true;
				recur(depth + 1);
				visited[i] = false;
			}
		}

	}

	private static void printResult() {
		String ans = "";
		if (result[0] == null) {
			System.out.println(s + " " + m + " = " + "No permutation");
		} else {
			for (int i = 0; i < result.length; i++) {
				ans += result[i];
			}

			System.out.println(s + " " + m + " = " + ans);
		}
	}

}
