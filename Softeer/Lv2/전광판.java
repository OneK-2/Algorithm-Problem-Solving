import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, int[]> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        map.put(0, new int[]{1, 1, 1, 1, 1, 1, 0});
        map.put(1, new int[]{0, 1, 1, 0, 0, 0, 0});
        map.put(2, new int[]{1, 1, 0, 1, 1, 0, 1});
        map.put(3, new int[]{1, 1, 1, 1, 0, 0, 1});
        map.put(4, new int[]{0, 1, 1, 0, 0, 1, 1});
        map.put(5, new int[]{1, 0, 1, 1, 0, 1, 1});
        map.put(6, new int[]{1, 0, 1, 1, 1, 1, 1});
        map.put(7, new int[]{1, 1, 1, 0, 0, 1, 0});
        map.put(8, new int[]{1, 1, 1, 1, 1, 1, 1});
        map.put(9, new int[]{1, 1, 1, 1, 0, 1, 1});

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arrA = new int[5];
            int[] arrB = new int[5];
            Arrays.fill(arrA, -1);
            Arrays.fill(arrB, -1);

            for (int j = 0; j < 5; j++) {
                arrA[j] = A % 10;
                A /= 10;
                if (A == 0) break;
            }
            for (int j = 0; j < 5; j++) {
                arrB[j] = B % 10;
                B /= 10;
                if (B == 0) break;
            }
            int answer = 0;

            for (int j = 0; j < 5; j++) {
                if (arrA[j] != arrB[j]) {
                    if (arrA[j] == -1) {
                        answer += countArr(arrB[j]);
                    } else if (arrB[j] == -1) {
                        answer += countArr(arrA[j]);
                    } else {
                        answer += compDiff(arrA[j], arrB[j]);
                    }
                }
            }
            System.out.println(answer);
        }

    }

    private static int compDiff(int a, int b) {
        int[] arrA = map.get(a);
        int[] arrB = map.get(b);

        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (arrA[i] != arrB[i])
                cnt++;
        }
        return cnt;
    }

    private static int countArr(int i) {
        int[] comp = map.get(i);
        int cnt = 0;
        for (int j = 0; j < 7; j++) {
            cnt += comp[j];
        }
        return cnt;
    }

}
