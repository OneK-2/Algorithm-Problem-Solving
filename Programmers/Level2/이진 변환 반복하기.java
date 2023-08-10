class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String str = s;

        int zeroCnt = 0;
        int idx = 0;
        while (!str.equals("1")) {
            // 제거할 0의 개수 cnt
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    zeroCnt++;
            }
            str = str.replace("0", "");
            int len = str.length();
            str = Integer.toBinaryString(len);
            idx++;
        }
        answer[0] = idx;
        answer[1] = zeroCnt;
        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }
}