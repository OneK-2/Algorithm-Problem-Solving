import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (c == 0) {
                unionTeam(a, b);
            } else if (c == 1) {
                if (findTeam(a) == findTeam(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static int findTeam(int a) {
        if (a == parent[a]) return a;
        return parent[a] = findTeam(parent[a]);
    }

    private static void unionTeam(int a, int b) {
        a = findTeam(a);
        b = findTeam(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}