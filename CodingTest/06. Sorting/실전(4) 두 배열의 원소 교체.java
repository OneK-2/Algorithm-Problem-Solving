import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Integer[] arr2 = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(arr2, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i] < arr2[j]) {
                    int tmp = arr[i];
                    arr[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}