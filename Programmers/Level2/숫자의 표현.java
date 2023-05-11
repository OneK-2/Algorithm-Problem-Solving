class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int idx = i;
            while (idx <= n) {
                sum += idx;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) break;
                idx++;
            }
            sum = 0;
        }
        return answer;
    }
}