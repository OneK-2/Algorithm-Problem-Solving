import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double arr[] = new double[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum1 = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sum1 += ((arr[i] / arr[arr.length - 1]) * 100);
        }
        System.out.print(sum1/arr.length);
    }
}
