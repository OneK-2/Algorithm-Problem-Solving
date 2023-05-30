import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            max = Math.max(max, hashMap.get(str));
        }
        ArrayList<String> arrayList = new ArrayList<String>(hashMap.keySet());
        Collections.sort(arrayList);
        for (String key : arrayList) {
            if (hashMap.get(key) == max) {
                System.out.println(key);
                break;
            }
        }
    }
}
