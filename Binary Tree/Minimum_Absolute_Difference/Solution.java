package Minimum_Absolute_Difference;

import Binary_Search_Tree.TreeNode;
import com.sun.source.tree.Tree;

class Solution {
    int minAbsDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        preorderTraversal(root);
        return minAbsDiff;
    }

    public TreeNode findPredecessor(TreeNode root){
        if(root == null) return null;
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    public TreeNode findSuccessor(TreeNode root){
        if(root == null) return null;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public void preorderTraversal(TreeNode root){
        if(root == null)return;

        if(root.left != null){
            TreeNode predecessor = findPredecessor(root.left);
            int diff = Math.abs(root.val - predecessor.val);
            minAbsDiff = Math.min(minAbsDiff,diff);
        }
        if(root.right != null){
            TreeNode successor = findSuccessor(root.right);
            int diff = Math.abs(root.val - successor.val);
            minAbsDiff = Math.min(minAbsDiff,diff);
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        Solution s = new Solution();
        System.out.println(s.getMinimumDifference(root));
    }
}