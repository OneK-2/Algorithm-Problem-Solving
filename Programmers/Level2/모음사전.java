class Solution {
    public int solution(String word) {
        int len = word.length();
        int answer = len;
        int[] arr = {781, 156, 31, 6, 1};
        int tmp;
        String str = "AEIOU";
        for (int i = 0; i < len; i++) {
            tmp = str.indexOf(word.charAt(i));
            answer += arr[i] * tmp;
        }
        return answer;
    }
}