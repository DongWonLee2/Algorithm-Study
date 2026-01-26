package week02.boj_1068;

import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] tree;
    static int root;
    static int deleteNode;
    static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else tree[parent].add(i);
        }

        // 트리 확인용
        // System.out.println(Arrays.toString(tree));

        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        countLeafDFS(root);
        System.out.print(leafCount);
    }

    private static void countLeafDFS(int node) {
        int children = 0;
        for(int nextNode : tree[node]) {
            if (nextNode != deleteNode) {
                children++;
                countLeafDFS(nextNode);
            }
        }

        if (children == 0) {
            leafCount++;
        }
    }
}
