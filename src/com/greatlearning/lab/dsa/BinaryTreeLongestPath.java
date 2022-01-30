package com.greatlearning.lab.dsa;

/**
 * @author rajatjain on - 30-01-2022
 * @project DSALabSolution
 */
public class BinaryTreeLongestPath {

    private Node root = null;

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int[] values = new int[]{100, 20, 130, 10, 50, 110, 140, 5};
        BinaryTreeLongestPath binaryTree = new BinaryTreeLongestPath();
        // Since the example given was a BST, All the elements are inserted using BST algorithm
        binaryTree.createBinaryTree(values);

        System.out.println("The Binary Tree in In-Order format - ");
        binaryTree.inorderPrint(binaryTree.root);

        binaryTree.printLongestPath(binaryTree);
    }

    private void printLongestPath(BinaryTreeLongestPath binaryTree) {
        System.out.println();
        System.out.println("The longest path in tree is - ");
        printLongestPath(binaryTree.root);
    }

    private void printLongestPath(Node root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            // LEAF Node
            System.out.print(root.key + " ");
        }else{
            System.out.print(root.key + " -> ");
        }
        int leftTreeHeight = heightOfTree(root.left);
        int rightTreeHeight = heightOfTree(root.right);
        if (leftTreeHeight > rightTreeHeight) {
            //recursively check left tree
            printLongestPath(root.left);
        } else {
            //recursively check right tree
            printLongestPath(root.right);
        }
    }

    private int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftTreeHeight = heightOfTree(root.left);
            int rightTreeHeight = heightOfTree(root.right);
            return Math.max(leftTreeHeight, rightTreeHeight) + 1;
        }
    }

    public void createBinaryTree(int[] inputs) {
        for (Integer value : inputs) {
            if (root == null) {
                root = insertValue(null, value);
            } else {
                insertValue(root, value);
            }
        }
    }

    private Node insertValue(Node root, Integer value) {
        Node newNode = new Node(value);
        Node currentNode = root;
        Node currentParent = null;

        while (currentNode != null) {
            currentParent = currentNode;
            if (value < currentNode.key) {
                currentNode = currentNode.left;
            } else if (value > currentNode.key) {
                currentNode = currentNode.right;
            } else {
                System.out.println("Value Already Exists");
                return currentNode;
            }
        }

        if (currentParent == null) {
            currentParent = newNode;
        } else if (value < currentParent.key) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }

        return currentParent;
    }

    private void inorderPrint(Node root) {
        if (root == null)
            return;
        else {
            inorderPrint(root.left);
            System.out.print(root.key + " ");
            inorderPrint(root.right);
        }
    }


}
