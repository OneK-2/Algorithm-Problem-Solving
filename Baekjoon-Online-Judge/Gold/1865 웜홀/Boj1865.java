import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] road;
    static int[] dis;
    static int N, M, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            //지점n, 도로개수m,웜홀w
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dis = new int[N + 1];
            road = new ArrayList[N + 1];
            Arrays.fill(dis, 97462341);

            for (int i = 0; i < N + 1; i++) {
                road[i] = new ArrayList<>();
            }

            // 도로 정보 (방향x)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()); // 연결지점번호
                int E = Integer.parseInt(st.nextToken()); // 연결지점번호
                int T = Integer.parseInt(st.nextToken()); // 걸린시간
                road[S].add(new Node(E, T));
                road[E].add(new Node(S, T));
            }

            // 웜홀 정보 (방향 o)
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()); //시작점
                int E = Integer.parseInt(st.nextToken()); //도착점
                int T = Integer.parseInt(st.nextToken()); //줄어든 시간
                road[S].add(new Node(E, -T));
            }
            if (bellmanFord()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean bellmanFord() {
        dis[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < road.length; j++) {
                for (Node n : road[j]) {
                    if (dis[j] + n.t < dis[n.e]) {
                        dis[n.e] = dis[j] + n.t;
                    }
                }
            }
        }
        for (int i = 1; i < road.length; i++) {
            for (Node n : road[i]) {
                if (dis[i] + n.t < dis[n.e])
                    return true;
            }
        }
        return false;
    }
}

class Node {
    int e;
    int t;

    public Node(int e, int t) {
        this.t = t;
        this.e = e;
    }
}