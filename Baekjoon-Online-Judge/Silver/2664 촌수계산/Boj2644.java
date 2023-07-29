import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, ans = 0;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); //전체 사람수
        visit = new boolean[n + 1];
        arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<Integer>());
        }

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken()); // 사람1
        int p2 = Integer.parseInt(st.nextToken()); // 사람2

        int m = Integer.parseInt(br.readLine()); //부모 자식들 간의 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dfs(p1, p2, 0);
        if (ans == 0) {
            System.out.println(-1);
        } else
            System.out.println(ans);
    }

    private static void dfs(int p1, int p2, int depth) {
        visit[p1] = true;

        for (int i : arr.get(p1)) {
            if (!visit[i]) {
                if (i == p2) {
                    ans = depth + 1;
                }
                dfs(i, p2, depth + 1);
            }
        }
    }
}
