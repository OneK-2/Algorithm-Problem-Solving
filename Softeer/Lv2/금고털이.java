import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken()); //배낭무게
        int N = Integer.parseInt(st.nextToken()); //귀금속 종류
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            //금속무게 M
            //무게당 가격 P
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (W > arr[i][0]) {
                sum += arr[i][0] * arr[i][1];
                W -= arr[i][0];
            } else if (W <= arr[i][0]) {
                sum += W * arr[i][1];
                break;
            }
        }
        System.out.println(sum);
    }
}