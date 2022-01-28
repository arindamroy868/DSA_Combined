package Ceil_Floor_Of_BST;

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

public class CeilAndFloorBST {
    public static TreeNode ceilValueNode(int value,TreeNode root){
        if(root == null) return null;
        TreeNode ceil = null;
        TreeNode current = root;
        while(current != null){
            if(current.val >= value){
                ceil = current;
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return ceil;
    }

    public static TreeNode floorValueNode(int value,TreeNode root){
        if(root == null) return null;
        TreeNode ceil = null;
        TreeNode current = root;
        while(current != null){
            if(current.val <= value){
                ceil = current;
                current = current.right;
            }else{
                current = current.left;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(15);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        TreeNode ceil = ceilValueNode(13,root);
        TreeNode floor = floorValueNode(9,root);
        System.out.println(ceil!=null?ceil.val:"null");
        System.out.println(floor!=null?floor.val:"null");
    }

}
