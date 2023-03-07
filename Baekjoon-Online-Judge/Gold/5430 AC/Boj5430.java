import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            ac(str, deque);
        }
        System.out.println(sb);
    }

    public static void ac(String str, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if (c == 'R') {
                isRight = !isRight;
            } else {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (!isRight) deque.removeLast();
                else deque.removeFirst();
            }
        }
        sb.append("[");
        if (!deque.isEmpty()) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }
}