class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        answer[0] = GCD(max, min);
        answer[1] = (n * m) / answer[0];

        return answer;
    }

    public int GCD(int max, int min) {
        if (min == 0) return max;
        else return GCD(min, max % min);
    }
}
