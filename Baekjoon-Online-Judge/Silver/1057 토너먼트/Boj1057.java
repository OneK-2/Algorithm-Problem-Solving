import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (kim != lim) {
            kim = kim / 2 + kim % 2;
            lim = lim / 2 + lim % 2;
            cnt++;
        }
        System.out.println(cnt);
    }
}