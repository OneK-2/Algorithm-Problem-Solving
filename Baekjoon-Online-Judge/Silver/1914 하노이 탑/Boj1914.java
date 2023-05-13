import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger b = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        sb.append(b).append("\n");
        if (n > 20) {
            System.out.println(sb);
        } else {
            hanoi(n, 1, 2, 3);
            System.out.println(sb);
        }
    }

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }
        //n-1개를 가운데 기둥으로 이동
        hanoi(n - 1, start, end, mid);
        //가장큰원판 마지막으로 이동
        sb.append(start).append(" ").append(end).append("\n");
        //n-1개를 가운데 기둥에서 마지막으로 이동
        hanoi(n - 1, mid, start, end);
    }
}
