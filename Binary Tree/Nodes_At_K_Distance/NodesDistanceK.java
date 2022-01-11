package Nodes_At_K_Distance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

public class NodesDistanceK {

    public static List<Integer> findNodesKDistance(TreeNode root,TreeNode start,Integer k){
        List<Integer> nodes = new ArrayList<>();
        if(root == null || start == null) return nodes;

        //Create Mapping of ChildNodes to Parent 
        Map<TreeNode,TreeNode> childToParentMap = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null) {
                q.add(curr.left);
                childToParentMap.put(curr.left, curr);
            }
            if(curr.right != null){
                q.add(curr.right);
                childToParentMap.put(curr.right,curr);
            }
        }
        
        Set<TreeNode> visited = new HashSet<>();
        q = new ArrayDeque<>();
        q.add(start);
        visited.add(start);
        Integer distance = 0;

        while(distance<k){
            int currNodes = q.size();
            for(int i=0;i<currNodes;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(curr != root && !visited.contains(childToParentMap.get(curr))){
                    q.add(childToParentMap.get(curr));
                    visited.add(childToParentMap.get(curr));
                }
            }
            distance++;
        }
        while(!q.isEmpty()){
            nodes.add(q.poll().val);
        }
        return nodes;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(8);
        node.left.right.left = new TreeNode(9);
        node.left.right.right = new TreeNode(11);

        node.right = new TreeNode(7);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(1);

        System.out.println(findNodesKDistance(node,node,2));
    }
}
