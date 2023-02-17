class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean check = true;
        for (int i = 0; i <= 9; i++) {
            check = false;
            for (int j = 0; j < numbers.length; j++) {
                if (i == numbers[j]) check = true;
            }
            if (!check) answer += i;
        }
        return answer;
    }
}
