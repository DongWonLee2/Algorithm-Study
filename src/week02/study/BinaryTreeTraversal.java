package week02.study;

import java.util.*;

public class BinaryTreeTraversal {

    // 1. 이진 트리 노드 정의
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 테스트 트리 생성
        //        1
        //      /   \
        //     2     3
        //    / \
        //   4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("전위 순회 (Pre-order):  "); preOrder(root); System.out.println();
        System.out.print("중위 순회 (In-order):   "); inOrder(root); System.out.println();
        System.out.print("후위 순회 (Post-order): "); postOrder(root); System.out.println();
        System.out.print("레벨 순회 (Level-order):"); levelOrder(root); System.out.println();
    }

    // 전위 순회
    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " "); // 나 방문
        preOrder(node.left);             // 왼쪽 방문
        preOrder(node.right);            // 오른쪽 방문
    }

    // 중위 순회
    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);              // 왼쪽 먼저 다녀오고
        System.out.print(node.val + " "); // 나 방문
        inOrder(node.right);             // 오른쪽 방문
    }

    // 후위 순회
    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);            // 왼쪽 다녀오고
        postOrder(node.right);           // 오른쪽 다녀오고
        System.out.print(node.val + " "); // 나 방문
    }

    // 레벨 순회
    public static void levelOrder(Node root) {
        if (root == null) return;

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + " ");

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }
}
