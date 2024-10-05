import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        return answer;
    }

    public int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] count = new int[n + 1];

        q.add(1);
        visited[1] = true;
        count[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int c : graph.get(cur)) {
                if (!visited[c]) {
                    visited[c] = true;
                    count[c] += count[cur] + 1;
                    q.add(c);
                }
            }
        }

        Arrays.sort(count);
        int max = count[count.length - 1];
        int answer = 0;
        for (int c : count) {
            if (max == c) {
                answer++;
            }
        }
        return answer;
    }
}

/**
 *
 */