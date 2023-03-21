import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (c == 'D') {
                    if (!map.isEmpty()) {
                        if (num == -1) {
                            int min = map.firstKey();
                            if (map.get(min) == 1) {
                                map.remove(min);
                            } else {
                                map.put(min, map.get(min) - 1);
                            }
                        } else {
                            int max = map.lastKey();
                            if (map.get(max) == 1) {
                                map.remove(max);
                            } else {
                                map.put(max, map.get(max) - 1);
                            }
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
