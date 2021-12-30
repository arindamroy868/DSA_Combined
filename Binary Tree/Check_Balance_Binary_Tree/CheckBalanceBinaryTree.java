package Check_Balance_Binary_Tree;

import Node.Node;
import Height_of_Tree.HeightOfTree;

public class CheckBalanceBinaryTree {
    /*  Time : O(N*2) This algorithm first check if the tree is balanced or not
        by finding the absolute difference of height of left subtree and height of right subtree.
        If the difference is >1 then the function returns false (This operation takes O(N) time)
        Else it will further check the balance of left subtree and right subtree
        If any of the subtree is unbalanced then the whole tree is unbalanced and function will return false
        (This operation takes O(N) time) So, overall time complexity comes to be O(N*2)

        Space : O(N) for skewed tree

    */
    public static boolean checkBalanceQuadratic(Node root){
        if(root == null) return true;
        int leftHeight = HeightOfTree.heightOfTree(root.left);
        int rightHeight = HeightOfTree.heightOfTree(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)return false;
        return (checkBalanceQuadratic(root.left) && checkBalanceQuadratic(root.right));
    } 
    
    /*
        Time : O(N) Instead of returning a boolean value we will instead return a +ve or -ve value based on result.
        When we are at root node we first check if the left & right subtree is balanced or not
        If any one of the subtree is unbalanced then we return -1
        If both left and right subtree is balanced then we check if the difference in their height >1 : if yes return -1
        So, How we reduced time complexity from O(N*2) to O(N)? Instead of return True||False we return the height of tree from each node
        Let's say we are at root node and we want to check if it is balanced or not.
        We call the function to recursively check if left subtree is balanced or not. If the tree is balanced then it will return the height of the subtree
        similarly for right subtree
        
        Space : O(N)
    */
    public static int checkBalanceLinear(Node root){
        if(root == null) return 0;
        int heightOfLeftSubtree = checkBalanceLinear(root.left);
        if(heightOfLeftSubtree == -1) return -1;
        int heightOfRightSubtree = checkBalanceLinear(root.right);
        if(heightOfRightSubtree == -1) return -1;

        if(Math.abs(heightOfLeftSubtree - heightOfRightSubtree) > 1) return -1;

        return 1+ Math.max(heightOfLeftSubtree,heightOfRightSubtree);
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        System.out.println(checkBalanceQuadratic(node));
        System.out.println(checkBalanceLinear(node));

    }
}
