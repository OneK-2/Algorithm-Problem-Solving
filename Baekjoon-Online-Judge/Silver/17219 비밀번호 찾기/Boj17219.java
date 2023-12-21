import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 사이트 주소와 비밀번호가 공백
        // 사이트 주소는 알파벳 소문자, 알파벳 대문자, 대시('-'), 마침표('.')
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String passwd = st.nextToken();
            map.put(site, passwd);
        }

        // 비밀번호를 찾으려는 사이트 주소가 한줄에 하나씩 입력
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            sb.append(map.get(str)).append("\n");
        }

        System.out.println(sb);
    }
}