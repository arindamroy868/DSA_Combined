package Children_Sum_Property;

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


public class ChildrenSumProperty {

    public static void convertChildrenSumBT(TreeNode node){
        if(node == null) return;
        int sum = 0;
        if(node.left != null) sum+= node.left.val;
        if(node.right != null) sum+=node.right.val;

        if(node.val > sum){
            if(node.left != null) node.left.val = node.val;
            if(node.right != null) node.right.val = node.val;
        }
        convertChildrenSumBT(node.left);
        convertChildrenSumBT(node.right);

        sum = 0;
        if(node.left != null) sum+= node.left.val;
        if(node.right != null) sum+=node.right.val;

        if(node.val <= sum) node.val = sum;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(20);
        node.left = new TreeNode(5);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(1);
        node.right.left = new TreeNode(10);
        node.right.left.left = new TreeNode(1);
        node.right.left.right = new TreeNode(5);
        node.right.right = new TreeNode(7);
        node.right.right.left = new TreeNode(15);
        node.right.right.right = new TreeNode(10);
        convertChildrenSumBT(node);
        System.out.println(node.val);

    }
}
