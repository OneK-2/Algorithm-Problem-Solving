import java.util.Scanner;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            int dir = 0;
            int curX = 0;
            int curY = 0;
            for (int i = 1; i <= N * N; i++) {
                arr[curX][curY] = i;
                if (inRange(curX, curY, dir, N) || arr[curX + dx[dir]][curY + dy[dir]] != 0) {
                    dir = (dir + 1) % 4;
                }
                curX += dx[dir];
                curY += dy[dir];
            }
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean inRange(int curX, int curY, int dir, int n) {
        return (curX + dx[dir] >= n) || (curY + dy[dir] >= n) ||
                (curX + dx[dir] < 0) || (curY + dy[dir] < 0);
    }
}