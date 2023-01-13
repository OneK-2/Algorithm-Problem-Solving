public class solution {
    public static int solution(String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String result = "";
            String prev = s.substring(0, step);
            int cnt = 1;

            for (int j = step; j < s.length(); j += step) {
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1;
                else {
                    result += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub;
                    cnt = 1;
                }
            }
            result += (cnt >= 2) ? cnt + prev : prev;
            answer = Math.min(answer, result.length());
        }
        return answer;
    }

}
