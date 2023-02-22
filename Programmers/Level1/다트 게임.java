class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] chance = new int[3];
        StringBuilder num = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char tmp = dartResult.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                num.append(tmp);
            } else if (tmp == 'S' || tmp == 'D' || tmp == 'T') {
                int n = Integer.parseInt(num.toString());
                if (tmp == 'S') {
                    chance[idx++] += Math.pow(n, 1);
                } else if (tmp == 'D') {
                    chance[idx++] += Math.pow(n, 2);
                } else {
                    chance[idx++] += Math.pow(n, 3);
                }
                num = new StringBuilder();
            } else {
                if (tmp == '*') {
                    chance[idx - 1] = chance[idx - 1] * 2;
                    if (idx - 2 >= 0) chance[idx - 2] = chance[idx - 2] * 2;
                } else {
                    chance[idx - 1] *= -1;
                }
            }
        }
        answer = chance[0] + chance[1] + chance[2];
        return answer;
    }
}