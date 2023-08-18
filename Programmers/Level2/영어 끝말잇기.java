package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		answer[0] = 0; // 가장먼저 탈락하는 사람번호
		answer[1] = 0; // 몇 번째 차례에 탈락하는지
		int len = words.length;
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < len; i++) { // 반복 횟수
			if (i == 0) {
				list.add(words[i]);
				continue;
			}
			int l = words[i - 1].length();
			char chk = words[i - 1].charAt(l - 1);
			char chk2 = words[i].charAt(0);

			if (chk != chk2 || list.contains(words[i])) { // 끝말잇기 실패
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}
			list.add(words[i]);
		}

		return answer;
	}
}