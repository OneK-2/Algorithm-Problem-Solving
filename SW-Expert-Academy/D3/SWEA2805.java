import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            int start = N / 2;
            int end = N / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    sum += arr[i][j];
                }
                if (i < N / 2) {
                    start -= 1;
                    end += 1;
                } else {
                    start += 1;
                    end -= 1;
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }

}