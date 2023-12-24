import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int min = Integer.MIN_VALUE;

        for (int[] r : routes) {
            if(min < r[0]){
                min = r[1];
                answer++;
            }
        }

        return answer;
    }
}