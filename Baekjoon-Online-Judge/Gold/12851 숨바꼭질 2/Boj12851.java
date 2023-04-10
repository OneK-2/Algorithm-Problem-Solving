import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int cnt, min;
    static int[] isVisited = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }
        search(N);
        System.out.println(min);
        System.out.println(cnt);
    }

    public static void search(int num) {
        Queue<Integer> queue = new LinkedList<>();
        min = 1000000;
        cnt = 0;
        queue.add(num);
        isVisited[num] = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (min < isVisited[now]) return;
            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = now - 1;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = 2 * now;
                }
                if (next == K) {
                    min = isVisited[now];
                    cnt++;
                }
                if (next >= 0 && next <= 100000 && (isVisited[next] == 0 || isVisited[next] == isVisited[now] + 1)) {
                    queue.add(next);
                    isVisited[next] = isVisited[now] + 1;
                }
            }
        }
    }
}
