import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MiddleOfLinkedList {

    public static Node findMiddle(Node head){
        if(head == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
