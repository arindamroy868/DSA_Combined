package Balance_BST;

import Binary_Search_Tree.TreeNode;
import java.util.Stack;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null ) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = balanceBST(root.left);
        TreeNode right = balanceBST(root.right);
        root.left = left;
        root.right = right;


        int balance = getBalance(root);
        if( Math.abs(balance) > 1 ){
            //Case 1: Left Heavy
            if(balance > 0){
                //If Left of Root is right heavy then left rotate it
                //LR
                if(getBalance(root.left) < 0){
                    root.left = leftRotate(root.left);
                }
                //LL
                root = rightRotate(root);
            }
            //Case 1: Right Heavy
            else{
                //If Right of Root is left heavy then right rotate it
                //RL
                if(getBalance(root.right) > 0){
                    root.right = rightRotate(root.right);
                }
                //RR
                root = leftRotate(root);
            }
        }

        if(!isBalanced(root)){
            return balanceBST(root);
        }
        return root;
    }

    public int getBalance(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight-rightHeight;
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right && Math.abs(getBalance(root)) <= 1;
    }

    public TreeNode rightRotate(TreeNode root){
        if(root == null || root.left == null) return root;
        TreeNode left = root.left;
        TreeNode leftRight = left.right;
        left.right = root;
        root.left = leftRight;
        return left;
    }

    public TreeNode leftRotate(TreeNode root){
        if(root == null || root.right == null) return root;
        TreeNode right = root.right;
        TreeNode rightLeft = right.left;
        right.left = root;
        root.right = rightLeft;
        return right;
    }

    public TreeNode insertNode(int value, TreeNode root) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        TreeNode current = root;
        while (true) {
            if (value < current.val) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(value);
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(value);
                    break;
                }
            }
        }
        return root;
    }

    public String preorder(TreeNode root){
        if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode topElement = stack.pop();
            sb.append(topElement.val).append(" ");
            if(topElement.right != null) stack.push(topElement.right);
            if(topElement.left != null) stack.push(topElement.left);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,15,14,17,7,2,12,3,9,11};
        Solution s = new Solution();
        TreeNode root = null;
        for(int x : arr){
            root = s.insertNode(x,root);
        }
        System.out.println(s.preorder(root));
        root = s.balanceBST(root);
        System.out.println(s.preorder(root));

    }
}