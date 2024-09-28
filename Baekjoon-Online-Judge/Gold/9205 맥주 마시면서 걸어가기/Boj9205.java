import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, hx, hy, dx, dy;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            //집좌표
            st = new StringTokenizer(br.readLine());
            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());
            //편의점좌표
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{x, y});
            }
            // 목적지 좌표
            st = new StringTokenizer(br.readLine());
            dx = Integer.parseInt(st.nextToken());
            dy = Integer.parseInt(st.nextToken());

            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n]; // 편의점 방문여부
        queue.add(new int[]{hx, hy});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            // 편의점 필요없는경우
            if (Math.abs(cx - dx) + Math.abs(cy - dy) <= 1000) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];
                    int dist = Math.abs(nx - cx) + Math.abs(ny - cy);
                    if (dist <= 1000) {
                        visited[i] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }

}


/**
 * 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).
 * 집, 편의점, 펜타포트 락 페스티벌 좌표
 */