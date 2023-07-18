package sw1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int ans = 1;

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 처음 숫자 패스

				char tmp = st.nextToken().charAt(0);

				if (st.hasMoreTokens()) { // 자식이 있을 때 연산자가 아니라면 0
					if (tmp >= '0' && tmp <= '9')
						ans = 0;
				} else { // 자식이 없을때 숫자가 아니면 0
					if (tmp < '0' || tmp > '9') {
						ans = 0;
					}
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}