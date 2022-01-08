package Left_View_of_BT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

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

class Tuple{
    TreeNode node;
    int vd;
    public void setVd(int vd) {
        this.vd = vd;
    }
    public void setNode(TreeNode node) {
        this.node = node;
    }
    Tuple(TreeNode node,int vd){
        setVd(vd);
        setNode(node);
    }
}

public class LeftViewBT {

    public static List<Integer> leftView(TreeNode root){
        List<Integer> leftView = new ArrayList<>();
        if(root == null) return leftView;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(root, 0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            if(!map.containsKey(tuple.vd)){
                map.put(tuple.vd,tuple.node.val);
            }
            if(tuple.node.left != null) q.add(new Tuple(tuple.node.left,tuple.vd + 1));
            if(tuple.node.right != null) q.add(new Tuple(tuple.node.right,tuple.vd + 1));
        }

        for(Integer val : map.values()){
            leftView.add(val);
        }
        return leftView;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(16);
        root.left.left.right = new TreeNode(20);
        root.left.right = new TreeNode(10);
        root.left.right.right = new TreeNode(15);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right =  new TreeNode(3);
        root.right.left =  new TreeNode(9);
        root.right.right =  new TreeNode(10);

        System.out.println(leftView(root));
    }
}
