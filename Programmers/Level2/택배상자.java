import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> bozo = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            bozo.add(i);
            while (!bozo.isEmpty()) {
                if (bozo.peek() == order[idx]) {
                    bozo.pop();
                    answer++;
                    idx++;
                } else
                    break;
            }
        }

        return answer;
    }
}