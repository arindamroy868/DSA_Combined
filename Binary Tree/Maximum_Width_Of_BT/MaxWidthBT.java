package Maximum_Width_Of_BT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    int pos;
    TreeNode node;
    Tuple(){};
    Tuple(TreeNode node,Integer pos){
        this.pos = pos;
        this.node = node;
    }
}
public class MaxWidthBT {
    

    public static int findMaxWidth(TreeNode node){
        Queue<Tuple> q = new ArrayDeque<>();
        if(node == null) return 0;
        int maxWidth = Integer.MIN_VALUE;
        q.add(new Tuple(node,1));

        while(!q.isEmpty()){
            List<Tuple> list = new ArrayList<>();
            while(!q.isEmpty()){
                list.add(q.poll());
            }
            int levelWidth = list.get(list.size()-1).pos - list.get(0).pos + 1;
            maxWidth = maxWidth<=levelWidth?levelWidth:maxWidth; 

            for(Tuple tuple : list){
               if(tuple.node.left != null){
                   q.add(new Tuple(tuple.node.left,tuple.pos*2));
                }
               if(tuple.node.right != null){
                q.add(new Tuple(tuple.node.right,tuple.pos*2 + 1));
                }
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);
        node.right.right.right = new TreeNode(8);

        System.out.println(findMaxWidth(node));
    }
}
