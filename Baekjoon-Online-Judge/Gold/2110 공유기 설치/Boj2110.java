import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int low = 1;
        int high = arr[n - 1] - arr[0] + 1;
        while (low < high) {
            int mid = (low + high) / 2;

            if (check(mid) < c) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low - 1);
    }

    public static int check(int dist) {
        int cnt = 1;
        int tmpLocate = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int locate = arr[i];

            if (locate - tmpLocate >= dist) {
                cnt++;
                tmpLocate = locate;
            }
        }
        return cnt;
    }
}