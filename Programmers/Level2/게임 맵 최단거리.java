import java.util.*;

class Solution {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] isVisited;

    public int solution(int[][] maps) {
        int answer = -1;
        isVisited = new int[maps.length][maps[0].length];
        bfs(maps);
        if (isVisited[maps.length - 1][maps[0].length - 1] != 0) {
            return answer = isVisited[maps.length - 1][maps[0].length - 1] + 1;
        } else
            return answer;
    }

    public static void bfs(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length) {
                    if (isVisited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        isVisited[nx][ny] = isVisited[x][y] + 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }

    }

    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}