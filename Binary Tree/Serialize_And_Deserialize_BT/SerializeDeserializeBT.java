package Serialize_And_Deserialize_BT;

import com.sun.source.tree.Tree;

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

public class SerializeDeserializeBT {
    public static List<Integer> levelOrderTraversal(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            result.add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return result;
    }
    public static String serializeBTLevelOrder(TreeNode root){
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if(parent != null){
                sb.append(parent.val);sb.append(",");
                q.add(parent.left);
                q.add(parent.right);
            }else {
                sb.append("null,");
            }
        }
        return sb.toString().trim().substring(0,sb.length()-1);
    }
    public static TreeNode deserializeBTLevelOrder(String serial){
        if(serial.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = serial.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        int pointer = 0;
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if (!values[++pointer].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[pointer]));
                if (parent != null) {
                    parent.left = left;
                    q.add(left);
                }
            }
            if (!values[++pointer].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[pointer]));
                if (parent != null) {
                    parent.right = right;
                    q.add(right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serializeBTLevelOrder(root));
        System.out.println(levelOrderTraversal(root));
        root = deserializeBTLevelOrder(serializeBTLevelOrder(root));
        System.out.println(levelOrderTraversal(root));
    }
}
