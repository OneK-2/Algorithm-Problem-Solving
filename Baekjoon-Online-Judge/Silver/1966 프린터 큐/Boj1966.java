import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> idxQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
                idxQueue.add(j);
            }
            int cnt = 1;

            while (!queue.isEmpty()) {
                int max = Collections.max(queue);
                int cur = queue.poll();
                int curIdx = idxQueue.poll();
                if (cur == max) {
                    if (curIdx == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    cnt++;
                } else {
                    queue.add(cur);
                    idxQueue.add(curIdx);
                }
            }
        }
        System.out.println(sb);
    }
}
