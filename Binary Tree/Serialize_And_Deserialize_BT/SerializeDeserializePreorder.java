package Serialize_And_Deserialize_BT;

import java.util.*;

public class SerializeDeserializePreorder {
    public static String serialize(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode parent = stack.pop();
            if(parent!=null) {
                sb.append(parent.val).append(",");
                stack.push(parent.right);
                stack.push(parent.left);
            }else{
                sb.append("null,");
            }
        }
        return sb.substring(0,sb.length()-1);
    }

    public static TreeNode deserialize(String s){
        if(s.trim().equals(""))return null;
        String[] values = s.trim().split(",");
        Deque<TreeNode> stack = new LinkedList<>();
        int pointer = 0;
        TreeNode parent;
        stack.push(new TreeNode(Integer.parseInt(values[pointer++])));
        TreeNode root = stack.peek();
        while(!stack.isEmpty()){
            parent = stack.peek();
            if(!values[pointer].equals("null")){
                parent.left = new TreeNode(Integer.parseInt(values[pointer++]));
                stack.push(parent.left);
                continue;
            }
            stack.pop();++pointer;
            if(!values[pointer].equals("null")){
                parent.right = new TreeNode(Integer.parseInt(values[pointer++]));
                stack.push(parent.right);
            }
        }
        return root;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(true){
            if(root != null){
                pre.add(root.val);
                if(root.right != null)st.push(root.right);
                root =  root.left;

            }else{
                if(st.isEmpty()) break;
                root = st.pop();
            }
        }
        return pre;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(11);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        System.out.println("Preorder traversal of original tree : "+preorderTraversal(root));
        System.out.println("Serialize of BT : "+serialize(root));
        System.out.println("Preorder traversal of reformed : "+preorderTraversal(deserialize(serialize(root))));
    }
}
