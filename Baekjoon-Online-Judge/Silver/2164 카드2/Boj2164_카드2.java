import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<Integer>();
        int n = Integer.parseInt(br.readLine());

        // 큐에 값 삽입
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 1~n번카드 1번이 제일 위
        // 제일 위에 버리고 그 다음카드 맨 밑으로
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }

}