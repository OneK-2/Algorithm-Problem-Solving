class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.toLowerCase().split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() == 0) {
                sb.append(" ");
            } else {
                sb.append(str[i].substring(0, 1).toUpperCase()).append(str[i].substring(1)).append(" ");
            }
        }

        if (s.charAt(s.length() - 1) == ' ') {
            return sb.toString();
        }
        return sb.substring(0, sb.length() - 1);
    }
}