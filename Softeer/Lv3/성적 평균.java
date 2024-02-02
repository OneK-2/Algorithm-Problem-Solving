import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        double[] arr = new double[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            double sum = 0;
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                sum += arr[j];
            }
            double result = sum / (e - s + 1);
            String res = String.format("%.2f", result);
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}
