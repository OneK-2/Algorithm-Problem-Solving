class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str = s.split("");
        int idx = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) idx = 0;
            else if (idx % 2 == 0) {
                str[i] = str[i].toUpperCase();
                idx++;
            } else {
                str[i] = str[i].toLowerCase();
                idx++;
            }
            answer.append(str[i]);
        }
        return answer.toString();
    }
}