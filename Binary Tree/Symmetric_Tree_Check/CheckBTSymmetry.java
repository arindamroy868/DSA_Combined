package Symmetric_Tree_Check;

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

public class CheckBTSymmetry {
    public static boolean checkSymmetry(TreeNode left,TreeNode right){
        if(left == null || right == null) return left == right;

        return (left.val == right.val) && checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        // root.right.left = new TreeNode(5);

        System.out.println(checkSymmetry(root, root));
    }
}
