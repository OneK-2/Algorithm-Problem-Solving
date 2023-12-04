import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] arr;
    static List<ArrayList<Integer>> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        arr = new int[(int) (Math.pow(2, k) - 1)];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        nodeList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            nodeList.add(new ArrayList<>());
        }

        search(0, arr.length - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j : nodeList.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void search(int start, int end, int depth) {
        if (depth == k) {
            return;
        }
        int mid = (start + end) / 2;
        nodeList.get(depth).add(arr[mid]);

        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }

}