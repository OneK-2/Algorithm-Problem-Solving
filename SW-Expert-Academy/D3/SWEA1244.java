import java.util.Scanner;

class Solution {
    static String[] arr;
    static int chance, max;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            arr = sc.next().split("");
            chance = sc.nextInt();

            if (chance > arr.length) {
                chance = arr.length;
            }
            max = 0;

            dfs(0, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void dfs(int start, int cnt) {
        if (cnt == chance) {
            StringBuilder tmp = new StringBuilder();
            for (String str : arr) {
                tmp.append(str);
            }
            max = Math.max(max, Integer.parseInt(tmp.toString()));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                String tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                dfs(i, cnt + 1);

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}