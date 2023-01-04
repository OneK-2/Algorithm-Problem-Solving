import java.io.IOException;


public class Main {
    public static long[] d = new long[100];

    public static void main(String[] args) throws IOException {
        System.out.println(fibo(50));
    }

    private static long fibo(int i) {
        if (i == 1 || i == 2) return 1;
        if (d[i] != 0) return d[i];
        d[i] = fibo(i - 1) + fibo(i - 2);
        return d[i];
    }
}
