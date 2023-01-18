import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now <= 'Z' && now >= 'A') {
                stack.push(arr[now - 'A']);
            } else if (now == '*') {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                stack.push(tmp2 * tmp1);
            } else if (now == '+') {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                stack.push(tmp2 + tmp1);
            } else if (now == '-') {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                stack.push(tmp2 - tmp1);
            } else if (now == '/') {
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                stack.push(tmp2 / tmp1);
            }
        }
        double result = stack.pop();
        System.out.println(String.format("%.2f",result));
    }
}