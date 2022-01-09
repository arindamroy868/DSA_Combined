package Path_From_Root_To_Node;

import java.util.ArrayList;
import java.util.List;

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

public class PathToNode{

    public static String findPathToNode(TreeNode node,Integer val){
        if(node == null) return "";

        if(node.val == val) return node.val.toString();

        String leftPath = findPathToNode(node.left, val);
        if(!leftPath.isBlank()) return node.val + "->" + leftPath;

        String rightPath = findPathToNode(node.right, val);
        if(!rightPath.isBlank()) return node.val + "->" + rightPath;

        return "";
    }

    public static boolean findPathToNode2(TreeNode node,Integer val,List<Integer> path){
        if(node == null) return false;
        path.add(node.val);
        if(node.val == val) return true;
        
        Boolean left = findPathToNode2(node.left, val, path);
        Boolean right = findPathToNode2(node.right, val, path);

        if(left || right) return true;
        else{
            path.remove(node.val);
            return false;
        }
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(5);
        node.left.right.right = new TreeNode(6);
        node.right = new TreeNode(3);

        System.out.println(findPathToNode(node, 5));
        List<Integer> result = new ArrayList<>();
        findPathToNode2(node, 5, result);
        System.out.println(result);
    }
}