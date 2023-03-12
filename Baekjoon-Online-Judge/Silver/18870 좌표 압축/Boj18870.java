import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] sorted = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        int cnt = 0;
        for (int v : sorted) {
            if (!map.containsKey(v)) {
                map.put(v, cnt);
                cnt++;
            }
        }
        for (int k : list) {
            int c = map.get(k);
            sb.append(c).append(' ');
        }
        System.out.println(sb);
    }
}
