package boj2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백트래킹
public class Main {
	static int n;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		backtracking("");
	}

	private static void backtracking(String str) {
		if (flag)
			return;
		if (str.length() == n) {
			System.out.println(str);
			flag = true;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (goodPer(str+i)) {
				backtracking(str + i);
			}
		}
	}

	private static boolean goodPer(String str) {
		int len = str.length();
		int mid = len / 2;
		for (int i = 1; i <= mid; i++) {
			String left = str.substring(len - i * 2, len - i);
			String right = str.substring(len - i, len);
			if (left.equals(right)) {
				return false;
			}
		}
		return true;
	}

}
