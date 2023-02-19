class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == ' ') answer += tmp;
            else if ('a' <= tmp && tmp <= 'z') {
                if (tmp + n > 'z') {
                    answer += (char) (tmp + n - 26);
                } else {
                    answer += (char) (tmp + n);
                }
            } else if ('A' <= tmp && tmp <= 'Z') {
                if (tmp + n > 'Z') {
                    answer += (char) (tmp + n - 26);
                } else {
                    answer += (char) (tmp + n);
                }
            }
        }

        return answer;
    }
}
