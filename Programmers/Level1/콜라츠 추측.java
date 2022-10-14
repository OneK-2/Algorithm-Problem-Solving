class Solution {
    public int solution(long num) {
        int answer = 0;
        int cnt = 0;

        while (cnt < 500) {
            if (num == 1) {
                return answer = cnt;
            }
            if (num % 2 == 0) {
                num /= 2;
                cnt++;
            } else {
                num = num * 3 + 1;
                cnt++;
            }
        }
        return answer = -1;
    }
}
