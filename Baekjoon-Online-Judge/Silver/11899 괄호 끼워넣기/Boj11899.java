import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
            } else {
                if (stack.isEmpty()) {
                    cnt++;
                } else {
                    stack.pop();
                }
            }
        }
        cnt+=stack.size();
        System.out.println(cnt);
    }
}