import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] dp = new int[D + 1];
        dp[0] = Integer.MAX_VALUE;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 길이
            int C = Integer.parseInt(st.nextToken()); // 용량

            for (int j = D; j >= L; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - L], C));
            }
        }
        System.out.println(dp[D]);
    }
}


/**
 * 수도관을 설치하여 거리 D(7 ≤ D ≤ 100,000)만큼
 * 떨어진 곳의 강에서 물을 끌어온다
 * 근처의 인간 마을에서 P개(1 ≤ P ≤ 350)의 파이프를 매입
 * 각각은 길이 Li와 용량 Ci로 나타낼 수 있다.
 * 파이프 길이 합 -> D
 * 용량은 파이프 중 가장 작은 거 기중
 * 최대 용량 구하기
 */