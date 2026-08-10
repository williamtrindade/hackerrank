package com.williamtrindade.binarySearchTreeInsertion;

import java.util.*;



class Solution {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

     /*
        Node is defined as :
            class Node
                int data;
                Node left;
                Node right;
    */

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        Node current = root;

        while (true) {
            if (data > current.data) {
                if (current.right == null) {
                    current.right = new Node(data);
                    break;
                }
                current = current.right;
            } else {
                if (current.left == null) {
                    current.left = new Node(data);
                    break;
                }
                current = current.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}