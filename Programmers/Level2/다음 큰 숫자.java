import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 2);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }

        answer = n;
        while (true) {
            answer++;
            int cnt2 = 0;
            String str2 = Integer.toString(answer, 2);

            for (int i = 0; i < str2.length(); i++) {
                if (str2.charAt(i) == '1') {
                    cnt2++;
                }
            }
            if (cnt == cnt2) {
                break;
            }
        }

        return answer;
    }
}