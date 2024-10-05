import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sol = n;
        int skill = k;

        answer = len;
        for (int i = 0; i < len; i++) {
            int cur = enemy[i];
            pq.add(cur);
            sol -= cur;

            if (sol < 0) {
                if (skill > 0 && !pq.isEmpty()) {
                    sol += pq.poll();
                    skill--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}

/**
 * n명으로 방어한다
 * 무적권 스킬 k번 사용 가능. 병사 소모없이 막을 수 있다.
 * 정렬해서 무적권 빼고 계산하면 될듯.
 * -> 이라고 생각했는데 잘못됨
 * 라운드마다 계산해야 되는데 정렬해서 제일 큰 숫자 라운드 전에 게임이 끝날수있다.
 * 따라서 라운드 순서대로 병사 차감하면서 pq에 값 넣었다가
 * 음수가 되면 pq값에 해당하는 라운드를 무적권으로 해결했다고 생각.
 */