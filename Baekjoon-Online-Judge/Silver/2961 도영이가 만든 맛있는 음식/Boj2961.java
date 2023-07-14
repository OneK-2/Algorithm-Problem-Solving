package boj2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] SB;

	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		SB = new int[n][2];

		for (int i = 0; i < n; i++) { // 신맛 0 쓴맛 b 1
			st = new StringTokenizer(br.readLine());
			SB[i][0] = Integer.parseInt(st.nextToken());
			SB[i][1] = Integer.parseInt(st.nextToken());
		}

		bit();
		System.out.println(result);
	}

	static void bit() {
		for (int i = 1; i < 1 << n; i++) {
			int sumS = 1, sumB = 0;
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0) {
					sumS *= SB[j][0];
					sumB += SB[j][1];
				}
			}
			result = Math.min(Math.abs(sumS - sumB), result);
		}

	}

}
