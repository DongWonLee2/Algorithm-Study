package week02.study;

import java.util.*;

public class GeneralTreeTraversal {

    // 일반 트리 노드 정의
    static class Node {
        int val;
        List<Node> children = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 테스트 트리 생성
        //        1
        //     /  |  \
        //    2   3   4
        //   / \
        //  5   6
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);

        node2.children.add(new Node(5));
        node2.children.add(new Node(6));

        System.out.print("전위 순회 (Pre-order):  "); preOrder(root); System.out.println();
        System.out.print("후위 순회 (Post-order): "); postOrder(root); System.out.println();
        System.out.print("중위 순회 (In-order):   "); inOrder(root); System.out.println();
        System.out.print("레벨 순회 (Level-order):"); levelOrder(root); System.out.println();
    }

    // 전위 순회 (Root -> Children, DFS)
    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.val + " "); // Root 방문
        for (Node child : node.children) {
            preOrder(child); // 자식들 순차 방문
        }
    }

    // 후위 순회 (Children -> Root)
    public static void postOrder(Node node) {
        if (node == null) return;
        for (Node child : node.children) {
            postOrder(child); // 자식들 먼저 다 방문
        }
        System.out.print(node.val + " "); // 마지막에 Root 방문
    }

    // 중위 순회 (First Child -> Root -> Rest Children)
    // 일반 트리에서는 보통 첫 번째 자식 탐색 후 루트를 방문하는 식으로 정의
    public static void inOrder(Node node) {
        if (node == null) return;

        if (node.children.size() > 0) {
            inOrder(node.children.get(0)); // 첫 번째 자식 방문
        }

        System.out.print(node.val + " "); // Root 방문

        for (int i = 1; i < node.children.size(); i++) {
            inOrder(node.children.get(i)); // 나머지 자식들 방문
        }
    }

    // 레벨 순회 (BFS)
    public static void levelOrder(Node root) {
        if (root == null) return;

        // 우리가 배운 ArrayDeque를 활용하자!
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + " ");

            for (Node child : curr.children) {
                queue.offer(child);
            }
        }
    }
}