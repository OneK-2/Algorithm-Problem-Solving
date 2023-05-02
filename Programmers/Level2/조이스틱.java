import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            //상하
            answer += Math.min(c - 'A', 26 - (c - 'A'));
            //좌우
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + len - next);
        }
        return answer + move;
    }
}