import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> tmp = new PriorityQueue<>();
        for (int i : scoville) {
            tmp.add(i);
        }
        while (tmp.peek() < K) {
            if (tmp.size() == 1) {
                return -1;
            }
            int n1 = tmp.poll();
            int n2 = tmp.poll();
            tmp.add(n1 + n2 * 2);

            answer++;
        }

        return answer;
    }
}