import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
            if (q.isEmpty()) {
                break;
            }
            q.offer(q.poll());
        }
        System.out.println(sb);
    }
}