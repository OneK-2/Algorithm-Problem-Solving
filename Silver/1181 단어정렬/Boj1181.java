import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Boj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }
        //양수면 변환, 0,음수면 변환x
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2); //길이가 같을경우 사전순정렬
                }else{
                    return o1.length()-o2.length();
                }
            }
        });
        LinkedHashSet<String> linkedhashSet = new LinkedHashSet<>(Arrays.asList(arr));
        arr = linkedhashSet.toArray(new String[0]);
        for(int i=0;i<arr.length;i++){
                sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
/**
 * treeset을 활용한 방법 참고
 *
 * TreeSet<String> words = new TreeSet<>(Comparator.comparing(String::length)
 *                 .thenComparing(Comparator.naturalOrder()));
 */
