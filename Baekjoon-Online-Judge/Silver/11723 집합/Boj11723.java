import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            } else if (str.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (str.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                set.remove(num);
            } else if (str.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (str.equals("all")) {
                for (int j = 0; j < 20; j++) {
                    set.add(j + 1);
                }
            } else if (str.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb);
    }
}
