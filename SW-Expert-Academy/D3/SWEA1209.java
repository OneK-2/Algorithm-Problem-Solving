import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
//        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            int sumCol = 0;
            int sumRow = 0;
            int sumCross = 0;
            int sumCross2 = 0;
            for (int i = 0; i < 100; i++) {
                sumCol = 0;
                sumRow = 0;
                sumCross += arr[i][i];
                sumCross2 += arr[i][99 - i];
                for (int j = 0; j < 100; j++) {
                    sumCol += arr[i][j];
                    sumRow += arr[j][i];
                }
                max = Math.max(max, sumCol);
                max = Math.max(max, sumRow);
            }
            max = Math.max(max, sumCross);
            max = Math.max(max, sumCross2);

            System.out.println("#" + test_case + " " + max);
        }
    }

}