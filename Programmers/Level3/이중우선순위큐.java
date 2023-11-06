import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations) {
            String[] ops = op.split(" ");
            int num = Integer.parseInt(ops[1]);

            if (ops[0].equals("I")) {
                maxPq.add(num);
                minPq.add(num);
            } else {
                if (num == -1)
                    maxPq.remove(minPq.poll());
                else {
                    minPq.remove(maxPq.poll());
                }
            }
        }
        answer[0] = maxPq.isEmpty() ? 0 : maxPq.peek();
        answer[1] = minPq.isEmpty() ? 0 : minPq.peek();
        return answer;
    }
}