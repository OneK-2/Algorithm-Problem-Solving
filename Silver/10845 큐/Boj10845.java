import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int back = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.contains("push")) {
                st = new StringTokenizer(str);
                st.nextToken();
                int input = Integer.parseInt(st.nextToken());
                queue.add(input);
                back = input;
            } else if (str.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1 + "\n");
                } else sb.append(queue.poll()).append("\n");

            } else if (str.equals("size")) {
                sb.append(queue.size()).append("\n");

            } else if (str.equals("empty")) {
                if (queue.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");

            } else if (str.equals("front")) {
                if (queue.isEmpty()) sb.append(-1 + "\n");
                else sb.append(queue.peek()).append("\n");

            } else if (str.equals("back")) {
                if (queue.isEmpty()) sb.append(-1 + "\n");
                else sb.append(back).append("\n");
            }
        }
        System.out.print(sb);
    }
}
