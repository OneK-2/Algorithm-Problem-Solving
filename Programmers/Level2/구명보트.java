import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int first = 0;
        int end = people.length - 1;

        while (first <= end) {
            if (people[first] + people[end] <= limit) {
                first++;
            }
            end--;
            answer++;
        }

        return answer;
    }
}