package Number_Of_Nodes_In_Complete_BT;

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

public class CompleteBinaryTreeNoOfNodes {
    public static int heightOfLeftTree(TreeNode root){
        if(root == null) return 0;
        return heightOfLeftTree(root.left) + 1;
    }
    public static int heightOfRightTree(TreeNode root){
        if(root == null) return 0;
        return heightOfLeftTree(root.right) + 1;
    }

    public static int findNumberOfNodesInCompleteBT(TreeNode root){
        if(root == null) return 0;
        int leftHeight = heightOfLeftTree(root.left);
        int rightHeight = heightOfRightTree(root.right);
        if(leftHeight == rightHeight){
            return (int)Math.pow(2,leftHeight+1) - 1;
        }
        return findNumberOfNodesInCompleteBT(root.left) + findNumberOfNodesInCompleteBT(root.right) + 1;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(5);
        node.left.right = new TreeNode(6);
        node.left.right.left = new TreeNode(7);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(10);
        System.out.println(findNumberOfNodesInCompleteBT(node));
    }
}
