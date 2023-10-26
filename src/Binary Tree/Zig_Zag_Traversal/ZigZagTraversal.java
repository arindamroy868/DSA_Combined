package Zig_Zag_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;


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
 
public class ZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.push(root);
        List<List<Integer>> result = new ArrayList<>();
        Boolean leftToRight = true;
        while(!q.isEmpty()){
            List<TreeNode> arr = new ArrayList<>();
            while(!q.isEmpty()){
                arr.add(q.poll());
            }

            for(TreeNode node : arr){
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            if(leftToRight){
                List<Integer> intArr = arr.stream().map(node -> node.val).collect(Collectors.toList());
                System.out.println(intArr);
                result.add(intArr);
            }
            else{
                Collections.reverse(arr);
                List<Integer> intArr = arr.stream().map(node -> node.val).collect(Collectors.toList());
                System.out.println(intArr);
                result.add(intArr);
            }
            leftToRight = !leftToRight;
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3); 
        zigzagLevelOrder(node1);
    }
}