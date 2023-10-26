package Boundary_Traversal_BT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(Integer val) { this.val = val; }
    TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BoundaryTraversal {
    public static List<Integer> boundaryTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        List<Integer> leftBoundary = leftBoundary(root);
        List<Integer> rightBoundary = rightBoundary(root);
        List<Integer> leafNodes = leafNodes(root);

        for(Integer x:leftBoundary){
            result.add(x);
        }

        for(Integer x:leafNodes){
            result.add(x);
        }

        for(int i=0;i<rightBoundary.size()-1;i++){
            result.add(rightBoundary.get(i));
        }
        return result;
    }

    public static List<Integer> leftBoundary(TreeNode root){
        List<Integer> leftBoundary = new ArrayList<>();
        if(root == null) return leftBoundary;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.left == null && curr.right == null) return leftBoundary;
            else{
                leftBoundary.add(curr.val);
                if(curr.left != null) stack.push(curr.left);
                else stack.push(curr.right);
            }
        }
        return leftBoundary;
    }

    public static List<Integer> rightBoundary(TreeNode root){
        List<Integer> rightBoundary = new ArrayList<>();
        if(root == null) return rightBoundary;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right == null && curr.left == null) {Collections.reverse(rightBoundary); return rightBoundary;}
            else{
                rightBoundary.add(curr.val);
                if(curr.right != null) stack.push(curr.right);
                else stack.push(curr.left);
            }
        }
        return rightBoundary;

    }

    public static List<Integer> leafNodes(TreeNode root){
        List<Integer> leafNodes = new ArrayList<>();
        if(root == null) return leafNodes;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.left == null && curr.right == null) leafNodes.add(curr.val);
            else{
                if(curr.right != null) stack.push(curr.right);
                if(curr.left != null) stack.push(curr.left);
            }
        }
        return leafNodes;
    }
    public static void main(Integer[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        node.left.right.right.left = new TreeNode(7);
        node.left.right.right.right = new TreeNode(8);
        node.left.right.right.left.left = new TreeNode(15);
        node.left.right.right.right.left = new TreeNode(14);

        node.right = new TreeNode(3);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(10);
        node.right.right.right = new TreeNode(11);
        node.right.right.right.left = new TreeNode(12);
        node.right.right.right.left = new TreeNode(13);

        System.out.println(boundaryTraversal(node));


    }
}
