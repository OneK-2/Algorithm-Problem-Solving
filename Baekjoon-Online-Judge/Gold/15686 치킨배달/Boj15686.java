import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, ans;
    static ArrayList<Node> home = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    home.add(new Node(i, j));
                }
                if (arr[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        backtracking(0, 0);
        System.out.println(ans);
    }

    private static void backtracking(int idx, int count) {
        if (count == m) {
            int res = 0;
            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dis = Math.abs(home.get(i).r - chicken.get(j).r)
                                + Math.abs(home.get(i).c - chicken.get(j).c);
                        tmp = Math.min(tmp, dis);
                    }
                }
                res += tmp;
            }
            ans = Math.min(ans, res);
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            visited[i] = true;
            backtracking(i + 1, count + 1);
            visited[i] = false;
        }
    }

}

class Node {
    int r, c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
