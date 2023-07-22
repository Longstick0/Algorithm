package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진 검색 트리
 */
public class A5639 {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (value > n) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else this.left.insert(n);
            }
            if (value < n) {
                if (this.right == null) {
                    this.right = new Node(n);
                } else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()), null, null);
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
