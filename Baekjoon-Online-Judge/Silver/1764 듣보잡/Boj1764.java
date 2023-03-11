import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                cnt++;
                ans.add(str);
            }
        }
        Collections.sort(ans);
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(ans.get(i));
        }
    }
}
