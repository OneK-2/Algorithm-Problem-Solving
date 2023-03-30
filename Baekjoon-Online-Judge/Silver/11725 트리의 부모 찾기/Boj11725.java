import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[N + 1];
        int[] pNode = new int[N + 1];
        for (int i = 0; i < N + 2; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int node : graph.get(cur)) {
                if (!isVisited[node]) {
                    isVisited[node] = true;
                    queue.add(node);
                    pNode[node] = cur;
                }
            }
        }
        for (int i = 2; i < N + 1; i++) {
            sb.append(pNode[i]).append("\n");
        }
        System.out.println(sb);
    }
}
