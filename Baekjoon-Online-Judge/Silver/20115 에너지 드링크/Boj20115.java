import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double max = 0;
        double sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }

        sum += max;
        for (int i = 0; i < N; i++) {
            if (arr[i] != max) {
                sum += arr[i] / 2;
            }
        }
        System.out.println(sum);
    }
}