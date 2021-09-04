import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


//Time = O(N+M)
//Space = O(1)

/*
 * Approach
 * We know that there is a point of intersection and there might me -ve numbers in the linked lists
 * If there were no -ve number then there is a simple approach in which we can traverse through the first linked list
 * and replace the numbers with their -ve counterpart
 * eg : ( we can change 8 to -8)
 * Dry Run
 * Here 3 will be our intersection point
 *
 * LL1 -> 1 -> 2 - > 3 -> 4 -> 5 -> 6
 *                   ^
 *                   |
 * LL2-> 10 -> 11 -> 12
 *
 * We can traverse through LL1 and make every element as -ve term
 *
 * After mutation our problem becomes
 *
 * LL1 -> (-1) -> (-2) - > (-3) -> (-4) -> (-5) -> (-6)
 *                          ^
 *                          |
 * LL2 ---> 10 ---> 11 ---> 12
 *
 * Now traverse in LL2 and when encounter any -ve node then return -1*node.data
 *
 * BUT THE ISSUE IS THAT THERE CAN BE -VE NUMBERS IN THE LINKED LISTS SO THIS APPROACH FAILS HERE
 *
 * BETTER APPROACH
 * Idea for approach is that we know how to find the start of a cycle in linked list and in this problem it looks like a cycle in Linked List but there isn't
 * So we can create our own cycle out of this Linked Lists by making the end of one linked list to join it's head
 *
 * {IN OUR CASE WE WILL MAKE THE TAIL OF LL1 TO POINT AT HEAD1}
 *
 *        ----------------------------
 *        |                          ^
 *        |                          |
 * LL1 -> 1 -> 2 - > 3 -> 4 -> 5 -> 6        Now 6.next = 1;
 *                   ^
 *                   |
 * LL2-> 10 -> 11 -> 12
 *
 * Now we changed our problem from finding the intersection point to finding the start of cycle
 * And we know how to solve it
 *
 *
 * */

public class IntersectionPointOfTwoLinkedList {
    int intersectPoint(Node head1, Node head2)
    {
        if(head1 == null || head2 == null){
            return -1;
        }
        Node curr = head1;
        while(curr.next != null){
            curr = curr.next;
        }
        //To Check if Intersection Point present or not
        Boolean junctionDetected = false;

        //Creating loop in first list
        curr.next = head1;

        //Iterating in second linked list
        Node slow = head2 , fast = head2;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                junctionDetected = true;
                break;
            }
        }
        if(!junctionDetected){
            return -1;
        }else{
            fast = head2;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow.data;
    }
}
