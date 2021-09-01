import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class Node{
    int data;
    public Node next = null;
    Node(int n){
        data = n;
    }
}
public class DetectCycleInLinkedList {
    public static boolean detectLoop(Node head){
        if(head == null){
            return false;
        }
        // Add code here
        Node slow = head;
        Node fast = head;

        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of linked list");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            //Creating Linked List
            Node tail = new Node(1);
            Node head = tail;
            for (int i = 2; i <= n; i++) {
                tail.next = new Node(i);
                tail = tail.next;
            }

            //Creating Cycle
            System.out.println("At which position do you want a loop? if pos = 0|n then no loop");
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            k%=n;
            if(k > 0){
                Node curr = head;
                while(k>1){
                    curr = curr.next;
                    k--;
                }
                tail.next = curr;
            }
            System.out.println(detectLoop(head));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
