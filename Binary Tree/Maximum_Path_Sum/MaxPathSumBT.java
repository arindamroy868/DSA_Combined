package Maximum_Path_Sum;

//   Definition for a binary tree node.
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
 
class MaxPathSumBT {
    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        int[] result = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root,result);
        return result[0];
    }
    
    public int maxPathSumHelper(TreeNode root,int[] result) {
        if(root == null) return 0;
        int lps = maxPathSumHelper(root.left,result);
        lps = lps>0?lps:0;
        int rps = maxPathSumHelper(root.right,result);
        rps = rps>0?rps:0;
        result[0] = Math.max(result[0],root.val + lps+rps);
        return Math.max(lps,rps) + root.val;
    }
}