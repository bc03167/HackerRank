package com.ta.april;

import java.io.*;
import java.util.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Day23BST {
    static int height = 0;
    static int level = 0;
    static Map<Integer, List<Integer>> m = new TreeMap<>();

    public static void levelOrder(Node r) {
        recursivelyBuildTreeMap(r);
        for (int i=1; i <= height; i++) {
            List<Integer> l = m.get(i);
            for (Integer data : l) {
                System.out.print(data+" ");
            }
        }
    }

    private static void recursivelyBuildTreeMap(Node r) {
        ++level;
        if (r == null)
            return;
        if (level > height)
            height = level;
        List<Integer> l = m.get(level);
        if (l == null)
            l = new LinkedList<>();
        l.add(r.data);
        m.put(level, l);
        //System.out.println("level="+level +" data="+r.data);

        recursivelyBuildTreeMap(r.left);
        level--;
        recursivelyBuildTreeMap(r.right);
        level--;
    }



    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root);
    }
}