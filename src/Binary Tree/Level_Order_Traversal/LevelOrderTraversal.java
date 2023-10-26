package Level_Order_Traversal;

import java.util.ArrayDeque;
import java.util.Deque;
import Node.Node;

class BinaryTree {
    Node root = null;

    BinaryTree(){};
    BinaryTree(Node node){
        root = node;
    }

    public void insertNode(int data){
        if(root == null){
            root = new Node(data);
        }else{
            Deque<Node> queue = new ArrayDeque<Node>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node current = queue.poll();
                if(current.left == null){
                    current.left = new Node(data);
                    return;
                }else if(current.right == null){
                    current.right = new Node(data);
                    return;
                }else{
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
        }
    }

    public void bfs(){
        if(root == null){
            System.out.println("Empty TREE");
        }else{
            Deque<Node> queue = new ArrayDeque<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node current = queue.poll();
                System.out.println(current.data);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
    }
}


public class LevelOrderTraversal{
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insertNode(11);
        bt.insertNode(2);
        bt.insertNode(32);
        bt.insertNode(423);
        bt.insertNode(5);
        bt.insertNode(6);
        bt.insertNode(7);
        bt.insertNode(8);
        bt.insertNode(9);
        bt.insertNode(10);
        bt.bfs();
    }
}