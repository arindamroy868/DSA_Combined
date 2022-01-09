package Lowest_Common_Ancestor;

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

public class LowestCommonAncestor {
    public static Integer findLCA(TreeNode node,Integer val1,Integer val2){
        if(node == null || val1 == null || val2 == null) return null;
        if(node.val == val1 || node.val == val2) return node.val;

        Integer left = findLCA(node.left,val1,val2);
        Integer right = findLCA(node.right,val1,val2);

        if(left == null) return right;
        if(right == null) return left;
        return node.val;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        node.right = new TreeNode(3);

        System.out.println(findLCA(node, 5, 3));
    }
}
