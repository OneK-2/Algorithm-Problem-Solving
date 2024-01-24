import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    static int n, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swapArr(i, j, i, j + 1);
                searchArr();
                swapArr(i, j, i, j + 1);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swapArr(i, j, i + 1, j);
                searchArr();
                swapArr(i, j, i + 1, j);
            }
        }
        System.out.println(max);
    }

    private static void searchArr() {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    private static void swapArr(int i, int j, int i1, int j1) {
        char tmp = arr[i][j];
        arr[i][j] = arr[i1][j1];
        arr[i1][j1] = tmp;
    }

}