package sw2806;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int[] arr;
	static int n, cnt;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			cnt = 0;

			recur(0);
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void recur(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (check(depth)) {
				recur(depth + 1);
			}
		}
	}

	private static boolean check(int col) {
		for (int i = 0; i < col; i++) { // col 이전 행들에 위치한 퀸들과 비교한다.
			if (arr[i] == arr[col]) { // 같은 행에 존재할 경우
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {// 대각선
				return false;
			}

		}
		return true;
	}

}