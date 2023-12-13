import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long mid = 0;
        long sum = 0;

        while (left <= right) {
            sum = 0;
            mid = (left + right) / 2;

            for (int t : times) {
                sum += mid / t;
            }

            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}