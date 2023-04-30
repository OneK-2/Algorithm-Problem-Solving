class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = temp; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    temp = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}