package Find_Kth_Smallest_Value;


import Binary_Search_Tree.TreeNode;

import java.util.Stack;

class Solution {
    public static int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else {
                current = stack.pop();
                k--;
                if (k == 0) {
                    return current.val;
                }
                current = current.right;
            }
        }
       return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root,1));
    }
}