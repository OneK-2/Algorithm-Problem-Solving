class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        while (n > i) {
            if (n % i == 1) {
                return answer = i;
            }
            i++;
        }
        return answer;
    }
}
