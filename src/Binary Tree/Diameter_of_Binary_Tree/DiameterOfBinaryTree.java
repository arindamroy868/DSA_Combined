package Diameter_of_Binary_Tree;

import Node.Node;

public class DiameterOfBinaryTree {
    static int diameter = 0;

    /*
        Naive Approach
        Time : O(N*2)
        We are calling heightOfTree method to calculate the height of left and right subtree 
        this causes O(N) time consumption. After we get the left and right height we update the diameter with
        maximum diameter found so far.
        Further we check the max length of path passing through the nodes in the left and right subtree of the current root.
        So, for each node in the BT we are traversing many nodes multiple times for finding the path length passing through it.

        Space : O(N)
    */
    public static int heightOfTree(Node root){
        if(root == null) return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh,rh) + 1; 
    }
    public static void diameterOfBinaryTreeNaive(Node root){
        if(root == null) return;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        diameter = Math.max(diameter, lh+rh);
        diameterOfBinaryTreeNaive(root.left);
        diameterOfBinaryTreeNaive(root.right);
    }

    public static int diameterOfBinaryTreeLinear(Node root){
        if(root == null) return 0;
        int lh = diameterOfBinaryTreeLinear(root.left);
        int rh = diameterOfBinaryTreeLinear(root.right);
        diameter = Math.max(diameter, lh+rh);
        return 1 + Math.max(lh,rh);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(4);
        node.right.left.left = new Node(5);
        node.right.left.right = new Node(6);
        node.right.left.right.left = new Node(7);
        diameterOfBinaryTreeLinear(node);
        System.out.println(DiameterOfBinaryTree.diameter);
    }
}
