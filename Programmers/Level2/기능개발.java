import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int len = progresses.length;
        for (int i = 0; i < len; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty() && day >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}