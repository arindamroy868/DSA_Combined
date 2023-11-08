import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MergeSortForLinkedList {

    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        Node mid = findMid(head);
        Node right = mid.next;
        mid.next = null;
        head = mergeSort(head);
        right = mergeSort(right);
        head = merge(head,right);
        return head;

    }

    public static Node findMid(Node head){
        if(head == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1,Node head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node result = null;
        if(head1.data<head2.data){
            result = head1;
            result.next = merge(head1.next,head2);
            }
        else {
            result = head2;
            result.next = merge(head1,head2.next);
            }
        return result;
    }
}
