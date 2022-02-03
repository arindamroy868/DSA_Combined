package Find_Mode_In_BST;

import Binary_Search_Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int maxCount = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer,Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        fillCountMap(countMap,root);
        for(Map.Entry<Integer,Integer> pair : countMap.entrySet()){
            if(pair.getValue() == maxCount){
                result.add(pair.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void fillCountMap(Map<Integer,Integer> countMap,TreeNode root){
        if(root != null){
            if(countMap.containsKey(root.val)){
                countMap.put(root.val,countMap.get(root.val) + 1);
                maxCount = maxCount<countMap.get(root.val)?countMap.get(root.val):maxCount;
            }else{
                countMap.put(root.val,1);
                maxCount = maxCount<countMap.get(root.val)?countMap.get(root.val):maxCount;
            }
            fillCountMap(countMap,root.left);
            fillCountMap(countMap,root.right);
        }
    }
}