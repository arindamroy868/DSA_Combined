import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CheckCircularLinkedList {
    boolean isCircular(Node head)
    {
        // Your code here
        if(head == null){
            return true;
        }
        Node curr = head.next;
        while(curr != null && curr != head){
            curr = curr.next;
        }
        if(curr == null){
            return false;
        }
        return true;
    }
}
