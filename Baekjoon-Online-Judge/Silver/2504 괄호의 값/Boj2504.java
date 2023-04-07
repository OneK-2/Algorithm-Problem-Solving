import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        int result = 0;
        int tmp = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    } else if (str.charAt(i - 1) == '(') {
                        result += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isValid = false;
                        break;
                    } else if (str.charAt(i - 1) == '[') {
                        result += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                }
            }
        }
        if (!isValid || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
