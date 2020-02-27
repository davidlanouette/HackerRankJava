package com.lanouette.treeHeightOfBinaryTree;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public static int height(Node root) {
        // Write your code here.
        return maxHeight(root, -1);
    }

    public static int maxHeight(Node root, int height) {
        if (root == null) {
            return height;
        }
        height++;

        int maxHeight = height;
        int hl = maxHeight(root.left, height);
        if (hl > maxHeight) {
            maxHeight = hl;
        }

        int hr = maxHeight(root.right, height);
        if (hr > maxHeight) {
            maxHeight = hr;
        }
        return maxHeight;
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
