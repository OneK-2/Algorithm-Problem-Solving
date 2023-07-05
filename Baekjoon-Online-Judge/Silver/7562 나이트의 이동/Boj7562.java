package boj7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			l = Integer.parseInt(br.readLine()); // 체스판 길이
			arr = new int[l][l];
			visited = new boolean[l][l];

			st = new StringTokenizer(br.readLine()); // 나이트 현 위치
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()); // 이동할 위치
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());

			bfs(x, y, tx, ty);
			sb.append(arr[tx][ty] + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y, int tx, int ty) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == tx && cur[1] == ty)
				break;
			for (int k = 0; k < 8; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if (inRange(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
					queue.add(new int[] { nx, ny });
				}

			}
		}

	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < l && ny < l;
	}

}
