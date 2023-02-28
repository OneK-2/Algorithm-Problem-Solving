import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) cnt1++;
            if (answers[i] == p2[i % p2.length]) cnt2++;
            if (answers[i] == p3[i % p3.length]) cnt3++;
        }
        int max = 0;
        max = Math.max(cnt1, Math.max(cnt2, cnt3));
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (max == cnt1) list.add(1);
        if (max == cnt2) list.add(2);
        if (max == cnt3) list.add(3);

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}