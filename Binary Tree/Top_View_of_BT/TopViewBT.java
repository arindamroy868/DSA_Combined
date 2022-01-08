package Top_View_of_BT;

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
    int hd;
    public void setHd(int hd) {
        this.hd = hd;
    }
    public void setNode(TreeNode node) {
        this.node = node;
    }
    Tuple(TreeNode node,int hd){
        setHd(hd);
        setNode(node);
    }
}

public class TopViewBT {
    public static List<Integer> topView(TreeNode root){
        List<Integer> topView = new ArrayList<>();
        if(root == null) return topView;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(root, 0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            if(!map.containsKey(tuple.hd)){
                map.put(tuple.hd,tuple.node.val);
            }
            if(tuple.node.left != null) q.add(new Tuple(tuple.node.left,tuple.hd - 1));
            if(tuple.node.right != null) q.add(new Tuple(tuple.node.right,tuple.hd + 1));
        }
        for(Integer val : map.values()){
            topView.add(val);
        }
        return topView;
    }

    public static void printTopView(TreeNode root){
        List<Integer> result = topView(root);
        for(Integer val : result){
            System.out.print(val +" ");
        }
        System.out.println();
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

        printTopView(root);
    }
}
