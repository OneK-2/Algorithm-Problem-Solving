import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int cnt1 = 1;
        int cnt2 = 1;
        int max = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) cnt1++;
            else cnt1 = 1;
            max = Math.max(cnt1, max);
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >= arr[i + 1]) cnt2++;
            else cnt2 = 1;
            max = Math.max(cnt2, max);
        }
        System.out.println(max);
    }
}