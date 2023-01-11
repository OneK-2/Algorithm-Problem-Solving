import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }

    // 시간이 짧은 것이 높은 우선순위
    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.time, o.time);
    }
}

public class Solution {
    public static int solution(int[] food_times, long k) {
        int len = food_times.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += food_times[i];
        }
        if (sum <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        sum = 0;
        long prev = 0;
        // sum + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (sum + ((pq.peek().getTime() - prev) * len) <= k) {
            int now = pq.poll().getTime();
            sum += (now - prev) * len;
            len -= 1;
            prev = now;
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }

        //음식번호 기준 정렬
        Collections.sort(answer, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });

        return answer.get((int) ((k - sum) % len)).getIndex();
    }

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }
}
