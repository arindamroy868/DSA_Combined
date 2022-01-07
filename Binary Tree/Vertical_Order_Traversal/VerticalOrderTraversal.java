package Vertical_Order_Traversal;

import java.util.ArrayList;
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

public class VerticalOrderTraversal {
    
    static Integer min = Integer.MAX_VALUE;
    static Integer max = Integer.MIN_VALUE;

    public static void findMinMaxLevels(TreeNode root,int hd){
        if(root == null) return;
        
        if(hd<min)min = hd;
        else if(hd>max)max = hd;

        findMinMaxLevels(root.left,hd-1);
        findMinMaxLevels(root.right,hd+1);
    }

    public static void printVerticalOrderTraversal(TreeNode root,int hd,int level){
        if(root == null) return;

        if(hd == level){
            System.out.print(root.val+" ");
        }
        printVerticalOrderTraversal(root.left, hd, level-1);
        printVerticalOrderTraversal(root.right, hd, level+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right =  new TreeNode(3);
        root.right.left =  new TreeNode(9);
        root.right.right =  new TreeNode(10);

        findMinMaxLevels(root, 0);
        for(int hd = min;hd<=max;hd++){
            printVerticalOrderTraversal(root, hd , 0);
            System.out.println();
        }

    }
}
