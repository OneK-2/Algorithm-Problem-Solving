import java.io.*;
import java.util.StringTokenizer;

public class Boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean isPrime[] = new boolean[k + 1];
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= k; i++) isPrime[i] = true;

        for (int i = 2; i * i <= k; i++) {
            if (isPrime[i])
                for (int j = i * i; j <= k; j += i) isPrime[j] = false;
        }

        for (int i = n; i <= k; i++) {
            if (isPrime[i] == true) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
