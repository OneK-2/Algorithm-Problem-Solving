import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //레지스터 초기값
            int b = Integer.parseInt(st.nextToken()); // 최종 값
            String[] answer = new String[10000];
            boolean[] isVisited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();

            isVisited[a] = true;
            queue.add(a);
            Arrays.fill(answer, "");
            while (!queue.isEmpty() && !isVisited[b]) {
                int cur = queue.poll();
                int D = (2 * cur) % 10000;
                int S = (cur == 0) ? 9999 : cur - 1;
                int L = (cur % 1000) * 10 + cur / 1000;
                int R = (cur % 10) * 1000 + cur / 10;

                if (!isVisited[D]) {
                    queue.add(D);
                    isVisited[D] = true;
                    answer[D] = answer[cur] + "D";
                }

                if (!isVisited[S]) {
                    queue.add(S);
                    isVisited[S] = true;
                    answer[S] = answer[cur] + "S";
                }

                if (!isVisited[L]) {
                    queue.add(L);
                    isVisited[L] = true;
                    answer[L] = answer[cur] + "L";
                }
                if (!isVisited[R]) {
                    queue.add(R);
                    isVisited[R] = true;
                    answer[R] = answer[cur] + "R";
                }

            }
            System.out.println(answer[b]);
        }
        /*
        D: n을 2배, 9999 초과 하면 10000으로 나눈 나머지 -> 2n mod 10000 저장
        S: n-1 저장, 0 일때 9999 저장
        L: 각 자릿수 왼쪽으로 회전 1,2,3,4 -> 2,3,4,1
        R: 오른쪽으로 회전 1,2,3,4 -> 4,1,2,3
         */
    }

}
