import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            pq.add(s.charAt(i));
        }
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}
