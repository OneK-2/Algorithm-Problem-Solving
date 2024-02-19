import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Node node = new Node(n);
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            node.insert(Integer.parseInt(input));
        }
        postOrder(node);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.node);
    }
}

class Node {
    int node;
    Node left, right;

    public Node(int node) {
        this.node = node;
    }

    public Node(int node, Node left, Node right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }

    public void insert(int n) {
        if (n < this.node) { // 작으면 왼쪽
            if (this.left == null) {
                this.left = new Node(n);
            } else {
                this.left.insert(n);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(n);
            } else {
                this.right.insert(n);
            }
        }
    }

}