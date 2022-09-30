package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {
    public static boolean[] isVisited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        isVisited = new boolean[node + 1];

        for (int i = 0; i < node + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= line; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(n).add(e);
            graph.get(e).add(n);
        }
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        dfs(start);
        isVisited = new boolean[node + 1];
        System.out.print("\n");
        bfs(start);
    }

    public static void dfs(int x) {
        isVisited[x] = true;
        System.out.print(x + " ");
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!isVisited[y]) dfs(y);
        }
    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        isVisited[x] = true;

        while (!queue.isEmpty()) {
            int y = queue.poll();
            System.out.print(y + " ");
            for (int i = 0; i < graph.get(y).size(); i++) {
                int z = graph.get(y).get(i);
                if (!isVisited[z]) {
                    queue.offer(z);
                    isVisited[z] = true;
                }
            }
        }
    }
}
