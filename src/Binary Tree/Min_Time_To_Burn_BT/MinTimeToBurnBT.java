package Min_Time_To_Burn_BT;


import java.util.*;

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

public class MinTimeToBurnBT {
    public static void fillParentMap(TreeNode root, Map<TreeNode,TreeNode> parentMap){
        if(root == null) return;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null) {
                q.add(curr.left);
                parentMap.put(curr.left,curr);
            }
            if(curr.right != null) {
                q.add(curr.right);
                parentMap.put(curr.right,curr);
            }
        }
    }
    public static int minTimeToBurnBT(TreeNode root,TreeNode start){
        if(root == null || start == null) return 0;
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        fillParentMap(root,parentMap);

        int time = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        visited.add(start);
        q.add(start);
        while(!q.isEmpty()){
            boolean burnedNeighbour = false;
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                TreeNode curr = q.poll();
                assert curr != null;
                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                    burnedNeighbour = true;
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                    burnedNeighbour = true;
                }
                if(parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))){
                    q.add(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    burnedNeighbour = true;
                }
            }
            if(burnedNeighbour) time++;
        }
        return time;
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

        System.out.println(minTimeToBurnBT(node,node.left));

    }
}
