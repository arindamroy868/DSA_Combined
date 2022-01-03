package Is_Same_Tree;

//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class IsSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p==q;
        
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && p.val == q.val;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3); 

        
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        // node2.right = new TreeNode(3);

        System.out.println(isSameTree(node1, node2));
    }
}
