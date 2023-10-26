package Binary_Search_Tree;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class BinarySearchTree {
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private TreeNode root;

    public BinarySearchTree(){}
    public BinarySearchTree(TreeNode root){
        if(root != null) this.root = root;
    }
    public BinarySearchTree(Integer val){
        this.root = new TreeNode(val);
    }
    public String preorder(){
        if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode topElement = stack.pop();
            sb.append(topElement.val).append(" ");
            if(topElement.right != null) stack.push(topElement.right);
            if(topElement.left != null) stack.push(topElement.left);
        }
        return sb.toString().trim();
    }
    public void insertNode(int value){
        if(this.root == null){
            this.root = new TreeNode(value);
            return;
        }

        TreeNode current = this.root;
        while(true){
            if(value < current.val){
                if(current.left != null){
                    current = current.left;
                }else{
                    current.left = new TreeNode(value);
                    break;
                }
            }else{
                if(current.right != null){
                    current = current.right;
                }else{
                    current.right = new TreeNode(value);
                    break;
                }
            }
        }
    }

    public TreeNode findInorderSuccessor(TreeNode root){
        if(root == null)return null;
        TreeNode current = root.right;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }
    public void deleteNode(int val){
        if(this.root == null) return;
        this.root = deleteNodeApproachRecursive(this.root,val);
    }
    public TreeNode deleteNodeApproachRecursive(TreeNode root,int val){
        if(root==null) return null;

        if(val < root.val){
             root.left = deleteNodeApproachRecursive(root.left,val);
        }else if(val > root.val){
            root.right = deleteNodeApproachRecursive(root.right,val);
        }
        else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            TreeNode successor = findInorderSuccessor(root);
            root.right = deleteNodeApproachRecursive(root.right,successor.val);
            successor.left = root.left;
            successor.right = root.right;
            return successor;
        }
        return root;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(7);
        bst.insertNode(4);
        bst.insertNode(3);
        bst.insertNode(6);
        bst.insertNode(5);
        bst.insertNode(10);
        bst.insertNode(8);
        bst.insertNode(15);
        bst.insertNode(12);

        System.out.println(bst.preorder());
        bst.deleteNode(5);
        System.out.println(bst.preorder());
        bst.deleteNode(7);
        System.out.println(bst.preorder());
    }
}
