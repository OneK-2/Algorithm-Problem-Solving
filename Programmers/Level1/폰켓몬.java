import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        int max = len / 2;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        if (set.size() >= max) answer = max;
        else answer = set.size();

        return answer;
    }
}