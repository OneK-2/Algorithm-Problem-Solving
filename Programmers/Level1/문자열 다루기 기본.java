class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6) return answer = false;
        for (int i = 0; i < s.length(); i++) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                return answer = false;
            } else if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                return answer = false;
            }
        }
        return answer;
    }
}
