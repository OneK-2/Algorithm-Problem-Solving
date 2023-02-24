class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int scoreR = 0, scoreT = 0, scoreC = 0, scoreF = 0, scoreJ = 0,
                scoreM = 0, scoreA = 0, scoreN = 0;

        for (int i = 0; i < survey.length; i++) {
            int score = Math.abs(choices[i] - 4);
            char tmp;
            if (choices[i] - 4 > 0) {
                tmp = survey[i].charAt(1);
            } else {
                tmp = survey[i].charAt(0);
            }

            switch (tmp) {
                case 'R':
                    scoreR += score;
                    break;
                case 'T':
                    scoreT += score;
                    break;

                case 'C':
                    scoreC += score;
                    break;
                case 'F':
                    scoreF += score;
                    break;

                case 'J':
                    scoreJ += score;
                    break;
                case 'M':
                    scoreM += score;
                    break;

                case 'A':
                    scoreA += score;
                    break;
                case 'N':
                    scoreN += score;
                    break;
            }
        }
        String u1 = "R";
        String u2 = "C";
        String u3 = "J";
        String u4 = "A";
        if (scoreR < scoreT) u1 = "T";
        if (scoreC < scoreF) u2 = "F";
        if (scoreJ < scoreM) u3 = "M";
        if (scoreA < scoreN) u4 = "N";

        return answer = u1 + u2 + u3 + u4;
    }
}