import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());

        //연속된거 교환 최대 s번 교환
        for (int i = 0; i < n && 0 < s; i++) {
            int max = arr[i];
            int maxIndex = i;
            for (int j = i + 1; j < n && j <= i + s; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            s -= maxIndex - i;
            while (maxIndex > i) {
                arr[maxIndex] = arr[maxIndex - 1];
                maxIndex--;
            }
            arr[i] = max;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}