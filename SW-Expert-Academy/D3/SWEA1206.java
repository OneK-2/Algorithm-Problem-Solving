import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        //T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i = 2; i < N - 2; i++) {
                int maxR = Math.max(arr[i + 1], arr[i + 2]);
                int maxL = Math.max(arr[i - 1], arr[i - 2]);
                int max = Math.max(maxL, maxR);
                if (arr[i] > max) {
                    sum += arr[i] - max;
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}