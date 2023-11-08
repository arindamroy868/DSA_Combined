package Vertical_Order_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
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

public class VerticalOrderTraversal {

    static Integer min = Integer.MAX_VALUE;
    static Integer max = Integer.MIN_VALUE;

    public static void findMinMaxLevels(TreeNode root,int hd){
        if(root == null) return;
        
        if(hd<min)min = hd;
        else if(hd>max)max = hd;

        findMinMaxLevels(root.left,hd-1);
        findMinMaxLevels(root.right,hd+1);
    }

    //Prints the vertical order of BT but does not maintain the vertical order of nodes in a line.
    //Time = O(N*2)-> For each horizontal level it visits n nodes. So for n horizontal levels it will take O(N) * O(N).
    //Space = O(N) -> Stack Trace
    public static void printVerticalOrderTraversal(TreeNode root,int hd,int level){
        if(root == null) return;

        if(hd == level){
            System.out.print(root.val+" ");
        }
        printVerticalOrderTraversal(root.left, hd, level-1);
        printVerticalOrderTraversal(root.right, hd, level+1);
    }

    public static void verticalOrderTraversal(TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map,int hd,int vd,TreeNode node){
        if(node == null) return;

        if(!map.containsKey(hd)){
            map.put(hd, new TreeMap<>());
        }
        if(!map.get(hd).containsKey(vd)){
            map.get(hd).put(vd,new PriorityQueue<>());
        }

        TreeMap<Integer, PriorityQueue<Integer>> verticalMap = map.get(hd);
        PriorityQueue<Integer> list = verticalMap.get(vd);
        list.add(node.val);
        verticalMap.put(vd,list);
        map.put(hd,verticalMap);

        verticalOrderTraversal(map, hd-1, vd+1, node.left);
        verticalOrderTraversal(map, hd+1, vd+1, node.right);
    }

    //Prints the vertical order of BT and maintains the vertical order of Nodes in a vertical line.
    //Time = O(N) -> Because travels each node only once
    //Space = O(N) -> Stack Trace
    public static void printVerticalOrderTraversal2(TreeNode root){
        if(root == null) return;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        verticalOrderTraversal(map, 0, 0, root);

        List<List<Integer>> list = new ArrayList<>();
        
        for(TreeMap<Integer, PriorityQueue<Integer>> levelMap : map.values()){
            List<Integer> levelList = new ArrayList<>();
            for(PriorityQueue<Integer> q : levelMap.values()){
                while(!q.isEmpty()){
                    levelList.add(q.poll());
                }
            }
            list.add(levelList);
        }
        
        for(List<Integer> integerList : list ){
            for(Integer val : integerList){
                System.out.print(val +" ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right =  new TreeNode(3);
        root.right.left =  new TreeNode(9);
        root.right.right =  new TreeNode(10);

        printVerticalOrderTraversal2(root);

    }
}
