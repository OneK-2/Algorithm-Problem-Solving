class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        int[] dpOne = new int[len];
        int[] dpTwo = new int[len];

        for (int i = 0; i < len; i++) {
            dpOne[i] = money[i];
            dpTwo[i] = money[i];
        }

        dpOne[0] = money[0];
        dpOne[1] = money[0];

        dpTwo[0] = 0;
        dpTwo[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpOne[i] = Math.max(dpOne[i - 2] + money[i], dpOne[i - 1]);
            dpTwo[i] = Math.max(dpTwo[i - 2] + money[i], dpTwo[i - 1]);
        }
        answer = Math.max(dpOne[len - 2], dpTwo[len - 1]);

        return answer;
    }
}