import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> word = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;

            word.put(str, word.getOrDefault(str, 0) + 1);
        }
        List<String> result = new ArrayList<>(word.keySet());

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (word.get(o1) == word.get(o2)) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return word.get(o2) - word.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}