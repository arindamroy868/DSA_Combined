package Height_of_Tree;

import Node.Node;

public class HeightOfTree {
    //Time : O(N) -> This will take linear time to check the height of tree
    //Space : O(N) -> This algorithm will take auxiliary stack space (Worst case is when the tree is skewed)
    public static int heightOfTree(Node root){
        if(root == null) return 0;
        return 1 + Math.max(heightOfTree(root.left),heightOfTree(root.right));
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        
        System.out.println(heightOfTree(node));
    }    
}
