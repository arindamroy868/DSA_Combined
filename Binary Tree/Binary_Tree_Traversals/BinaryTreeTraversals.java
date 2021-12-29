package Binary_Tree_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Node.Node;

public class BinaryTreeTraversals {

    public static void preorderTraversalRecursion(Node root){
        if(root == null) return;
        System.out.print(root.data +" ");
        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);
    }

    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        
        while(true){
            if(root != null){
                pre.add(root.data);
                if(root.right != null)st.push(root.right);
                root =  root.left;
                   
            }else{
                    if(st.isEmpty()) break;
                    root = st.pop();
                }
            }
        return pre;
    }

    public static void inorderTraversalRecursion(Node root){
        if(root == null) return;
        inorderTraversalRecursion(root.left);
        System.out.print(root.data +" ");        
        inorderTraversalRecursion(root.right);
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<Node>();
        
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty()) break;
                root = st.pop();
                list.add(root.data);
                root = root.right;
            }
        }
        return list;
    }

    public static void postorderTraversalRecursion(Node root){
        if(root == null) return;
        postorderTraversalRecursion(root.left);
        postorderTraversalRecursion(root.right);
        System.out.print(root.data +" ");        
    }

    public static List<Integer> postorderTraversal(Node root) {
        Stack<Node> st = new Stack<Node>();
        List<Integer> post =  new ArrayList<Integer>();
        Node curr = root;
        Node temp = null;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    post.add(temp.data);
                    while(!st.isEmpty() && st.peek().right == temp){
                        temp = st.pop();
                        post.add(temp.data);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return post;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        node.left.right.right = new Node(7);

        preorderTraversalRecursion(node);
        System.out.println();
        System.out.println(preorderTraversal(node));
        System.out.println();
        inorderTraversalRecursion(node);
        System.out.println();
        System.out.println(inorderTraversal(node)); 
        System.out.println();
        postorderTraversalRecursion(node);
        System.out.println();
        System.out.println(postorderTraversal(node));
        System.out.println();

    }
}
