import java.io.*;
import java.util.StringTokenizer;

public class Boj2798 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int N = fr.nextInt();
        int M = fr.nextInt();

        int arr[] = new int[300];
        int result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (arr[i] + arr[j] + arr[k] <= M && arr[i] + arr[j] + arr[k] >= result)
                        result = arr[i] + arr[j] + arr[k];
                }
            }
        }
        System.out.print(result);

    }

    public static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
