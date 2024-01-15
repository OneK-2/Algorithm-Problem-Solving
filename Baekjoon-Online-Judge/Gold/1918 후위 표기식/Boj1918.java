import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            switch (cur) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && cirPriority(stack.peek()) >= cirPriority(cur)) {
                        sb.append(stack.pop());
                    }
                    stack.add(cur);
                    break;
                case '(':
                    stack.add(cur);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(cur);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int cirPriority(Character peek) {
        if (peek == '(' || peek == ')') {
            return 0;
        } else if (peek == '+' || peek == '-') {
            return 1;
        } else if (peek == '*' || peek == '/') {
            return 2;
        }
        return -1;
    }

}