package Preorder_To_BST;


//  Definition for a binary tree node.
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

public class Preorder_To_BST {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0)return null;
        int start = 0;
        int end = preorder.length-1;

        return helperFunction(preorder,start,end);

    }

    public Integer findMid(int[] preorder,int start,int end,int val){
        int mid = start+1;
        while(mid<=end){
            if(preorder[mid]>preorder[start]){
                break;
            }
            mid++;
        }
        return mid;
    }

    public TreeNode helperFunction(int[] preorder,int start,int end){
        if(start>end) return null;

        TreeNode root = new TreeNode(preorder[start]);
        int mid = findMid(preorder,start,end,root.val);
        root.left = helperFunction(preorder,start+1,mid-1);
        root.right = helperFunction(preorder,mid,end);
        return root;
    }
}
