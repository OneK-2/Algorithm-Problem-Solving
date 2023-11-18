import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
//        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(); //덤프횟수
            int[] arr = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }
            Arrays.sort(arr);

            System.out.println("#" + test_case + " " + (arr[99] - arr[0]));
        }
    }

}