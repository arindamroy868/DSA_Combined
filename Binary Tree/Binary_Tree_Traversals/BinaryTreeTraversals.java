package Binary_Tree_Traversals;

import java.util.Stack;

import Node.Node;

public class BinaryTreeTraversals {

    public static void preorderTraversalRecursion(Node root){
        if(root == null) return;
        System.out.print(root.data +" ");
        preorderTraversalRecursion(root.left);
        preorderTraversalRecursion(root.right);
    }

    public static void preorderTraversalIterative(Node root){
        Stack<Node> st = new Stack<>();
        while(true){
            if(root != null){
                System.out.print(root.data + " ");
                if(root.right != null) st.push(root.right);
                root = root.left;
            }else{
                if(st.isEmpty()) break;
                root = st.pop();
            }
        }
    }

    public static void inorderTraversalRecursion(Node root){
        if(root == null) return;
        inorderTraversalRecursion(root.left);
        System.out.print(root.data +" ");        
        inorderTraversalRecursion(root.right);
    }

    public static void inorderTraversalIterative(Node root){
        Stack<Node> st = new Stack<>();
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }else{
                if(st.isEmpty()) break;
                root = st.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    public static void postorderTraversalRecursion(Node root){
        if(root == null) return;
        postorderTraversalRecursion(root.left);
        postorderTraversalRecursion(root.right);
        System.out.print(root.data +" ");        
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
        preorderTraversalIterative(node);
        System.out.println();
        inorderTraversalRecursion(node);
        System.out.println();
        inorderTraversalIterative(node);
        System.out.println();
        postorderTraversalRecursion(node);
    }
}
