import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int cnt = 0;
    public static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //인덱스 = 열, 값 = 행
        arr = new int[n];

        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (check(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean check(int depth) {
        for (int i = 0; i < depth; i++) {
            //입력 열의 행 i열의 행 비교
            if (arr[i] == arr[depth]) {
                return false;
            }
            //대각선일때 -> 열의 차이와 행의 차이가 같을 때
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}