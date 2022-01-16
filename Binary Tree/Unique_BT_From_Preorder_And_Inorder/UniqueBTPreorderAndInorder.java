package Unique_BT_From_Preorder_And_Inorder;

import Binary_Tree_Traversals.BinaryTreeTraversals;
import Node.Node;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class UniqueBTPreorderAndInorder {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(true){
            if(root != null){
                pre.add(root.val);
                if(root.right != null)st.push(root.right);
                root =  root.left;

            }else{
                if(st.isEmpty()) break;
                root = st.pop();
            }
        }
        return pre;
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty()) break;
                root = st.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
    public static TreeNode constructUniqueBT(int[] preorder,int[] inorder,int l1,int r1,int l2,int r2){
        if(l1>r1 || l2>r2)return null;
        int current = preorder[l1];
        TreeNode currentRoot = new TreeNode(current);
        int p = findRootPos(inorder,current);

        int leftTreeLength = p - l2;
        currentRoot.left = constructUniqueBT(preorder,inorder,l1+1,l1+leftTreeLength,l2,p-1);
        currentRoot.right = constructUniqueBT(preorder,inorder,l1+leftTreeLength+1,r1,p+1,r2);
        return currentRoot;
    }

    private static int findRootPos(int[] inorder, int current) {
        for(int i = 0 ;i<inorder.length;i++){
            if(inorder[i] == current) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder  = new int[]{10,15,7,2,6,20,21,29};
        int[] inorder   = new int[]{2,7,6,15,10,21,29,20};
        TreeNode root = constructUniqueBT(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        System.out.println(preorderTraversal(root));
        System.out.println(inorderTraversal(root));
    }
}
