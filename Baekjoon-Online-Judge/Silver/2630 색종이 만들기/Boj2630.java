import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void count(int x, int y, int size) {
        if (colorCheck(x, y, size)) {
            if (arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = size / 2;
        count(x, y, newSize);   //2사분면
        count(x, y + newSize, newSize); //1
        count(x + newSize, y, newSize); //3
        count(x + newSize, y + newSize, newSize); //4
    }

    public static boolean colorCheck(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
