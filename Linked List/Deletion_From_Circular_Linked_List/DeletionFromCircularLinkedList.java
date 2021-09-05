import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class DeletionFromCircularLinkedList {
    public static Node removeCycle(Node head){
        if(head == null){
            return null;
        }
        Node curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
    static String printLL(Node head) {
        if (head == null) {
            return "null";
        }
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.data + " ");
            curr = curr.next;
        }
        return sb.append("\n").toString();
    }
    static String printCircularLL(Node head) {
        if (head == null) {
            return "null";
        }
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append(curr.data+" ");
        curr = curr.next;
        while (curr != head) {
            sb.append(curr.data + " ");
            curr = curr.next;
        }
        return sb.append("\n").toString();
    }
    public static Node addLast(Node head,int data){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = new Node(data);
        return head;
    }
    public static Node createLoop(Node head){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        return head;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of linked list");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node head = null;
            if(n>0){
                System.out.println("Please enter elements of linked list");
                st = new StringTokenizer(br.readLine());
                head = new Node(Integer.parseInt(st.nextToken()));
                while(--n>0){
                    head = addLast(head,Integer.parseInt(st.nextToken()));
                }
                head = createLoop(head);
            }
            System.out.println("Before loop removal = "+printCircularLL(head));
            System.out.println("After loop removal = "+printLL(removeCycle(head)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
