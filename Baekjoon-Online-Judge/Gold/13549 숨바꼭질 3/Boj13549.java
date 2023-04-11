import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int pos;
    int time;

    public Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}

public class Main {
    static int N;
    static int K;
    static int min_time = 1000000;
    static boolean[] isVisited = new boolean[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
        } else {
            search(N);
            System.out.println(min_time);
        }

    }

    public static void search(int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(num, 0));
        isVisited[num] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.pos == K) {
                min_time = now.time;
            }
            if (now.pos * 2 <= 100000 && !isVisited[now.pos * 2]) {
                queue.offer(new Node(now.pos * 2, now.time));
                isVisited[now.pos * 2] = true;
            }
            if (now.pos - 1 >= 0 && !isVisited[now.pos - 1]) {
                queue.offer(new Node(now.pos - 1, now.time + 1));
                isVisited[now.pos - 1] = true;
            }
            if (now.pos + 1 <= 100000 && !isVisited[now.pos + 1]) {
                queue.offer(new Node(now.pos + 1, now.time + 1));
                isVisited[now.pos + 1] = true;
            }
        }
    }
}
