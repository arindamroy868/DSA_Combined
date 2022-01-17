package Unique_BT_From_Inorder_And_Postorder;

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


public class UniqueBTPostorderAndInorder {
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> post =  new ArrayList<>();
        TreeNode curr = root;
        TreeNode temp;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    post.add(temp.val);
                    while(!st.isEmpty() && st.peek().right == temp){
                        temp = st.pop();
                        post.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return post;
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
    public static TreeNode constructUniqueBT(int[] postorder,int[] inorder,int postStart,int postEnd,int inStart,int inEnd){
        if(postStart>postEnd || inStart>inEnd)return null;
        int current = postorder[postEnd];
        TreeNode currentRoot = new TreeNode(current);
        int p = findRootPos(inorder,current);

        int leftTreeLength = p - inStart;
        currentRoot.left = constructUniqueBT(postorder,inorder,postStart,postStart+leftTreeLength-1,inStart,p-1);
        currentRoot.right = constructUniqueBT(postorder,inorder,postStart+leftTreeLength,postEnd-1,p+1,inEnd);
        return currentRoot;
    }

    private static int findRootPos(int[] inorder, int current) {
        for(int i = 0 ;i<inorder.length;i++){
            if(inorder[i] == current) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] postorder  = new int[]{6,5,7,11,9,2,3,15,10};
        int[] inorder   = new int[]{11,6,7,5,10,2,9,15,3};
        TreeNode root = constructUniqueBT(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
        System.out.println(postorderTraversal(root));
        System.out.println(inorderTraversal(root));
    }
}
