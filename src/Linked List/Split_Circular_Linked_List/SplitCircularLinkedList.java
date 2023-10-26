import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class circular_LinkedList{
    Node head,head1,head2;
}

public class SplitCircularLinkedList {
    public static void splitList(circular_LinkedList list)
    {
        // Your code here
        //If the linked list is empty then the other lists will be empty as well
        if(list.head == null){
            list.head1 = list.head2 =  null;
            return;
        }
        //If linked list has only one node then the first list will be that node and the second list will be null
        else if(list.head.next == list.head){
            list.head1 = list.head;
            list.head1.next = null;
            list.head2 = null;
            return;
        }
        //Else we find the mid element of the circular linked list with slow-fast pointers
        Node slow = list.head;
        Node fast = list.head;

        //We increment fast by 2 node and slow by 1 node till fast reach the last node for odd number of nodes
        //or the second last node in for even number of nodes
        while(fast.next != list.head && fast.next.next != list.head){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == list.head){
            fast.next = null;
        }else{
            fast.next.next = null;
        }
        //Make head of second list as the next node of linked list
        list.head2 = slow.next;
        slow.next = null;
        list.head1 = list.head;

        list.head1 = createLoop(list.head1);
        list.head2 = createLoop(list.head2);
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

    static String printLL(Node head) {
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


    public static void main(String[] args) {
        try{
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
            circular_LinkedList c = new circular_LinkedList();
            c.head = head;
            splitList(c);
            System.out.println(printLL(c.head1));
            System.out.println(printLL(c.head2));
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
