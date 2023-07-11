package boj12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] myArr;
	static int[] checkArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int ans = 0;

		char[] dna = new char[s];
		checkArr = new int[4]; // 제한
		myArr = new int[4];

		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) { // {‘A’, ‘C’, ‘G’, ‘T’}
			checkArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p; i++) { // 첫 부분문자열 셋팅
			if (dna[i] == 'A')
				myArr[0]++;
			if (dna[i] == 'C')
				myArr[1]++;
			if (dna[i] == 'G')
				myArr[2]++;
			if (dna[i] == 'T')
				myArr[3]++;
		}
		if (check()) {
			ans++;
		}

		for (int i = p; i < s; i++) {
			int j = i - p;
			// 시작문자제외
			if (dna[j] == 'A')
				myArr[0]--;
			if (dna[j] == 'C')
				myArr[1]--;
			if (dna[j] == 'G')
				myArr[2]--;
			if (dna[j] == 'T')
				myArr[3]--;
			// 끝 문자 추가
			if (dna[i] == 'A')
				myArr[0]++;
			if (dna[i] == 'C')
				myArr[1]++;
			if (dna[i] == 'G')
				myArr[2]++;
			if (dna[i] == 'T')
				myArr[3]++;

			if (check()) {
				ans++;
			}
		}
		System.out.println(ans);

	}

	public static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (myArr[i] < checkArr[i])
				return false;
		}
		return true;
	}

}
