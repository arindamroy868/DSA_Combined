package BST_Iterator;

import Binary_Search_Tree.TreeNode;

import java.util.Stack;

class BSTIterator {
    private static Stack<TreeNode> stack;
    // Fills all nodes in stack coming in the path from node to the smallest node recursively.
    // Path = node to left most node in the tree
    public static void fillLeftNodes(TreeNode root){
        stack = new Stack<>();
        if(root != null){
            stack.push(root);
            fillLeftNodes(root.left);
        }
    }
    public BSTIterator(TreeNode root) {
        fillLeftNodes(root);
    }

    public int next() {
        TreeNode root = stack.pop();
        if(root.right != null){
            fillLeftNodes(root.right);
        }
        return root.val;
    }

    public boolean hasNext() {
        return stack != null && !stack.isEmpty();
    }
}
