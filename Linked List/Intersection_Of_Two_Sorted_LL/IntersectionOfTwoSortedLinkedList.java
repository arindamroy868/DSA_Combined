import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class IntersectionOfTwoSortedLinkedList {
    public static Node findIntersection(Node head1, Node head2)
    {
        if(head1 == null || head2 == null){
            return null;
        }
        Node newHead = null;
        while(head1 != null && head2  != null){
            if(head1.data == head2.data){
                newHead = addNode(newHead,head1.data);
                head1 = head1.next;
                head2 = head2.next;
            }else{
                if(head1.data < head2.data){
                    head1 = head1.next;
                }else{
                    head2 = head2.next;
                }
            }
        }
        return reverseLL(newHead);
    }
    public static Node reverseLL(Node head){
        if(head == null){
            return null;
        }
        Node prev = null,current = head,next = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node addNode(Node head,int data){
        if(head == null){
            return new Node(data);
        }
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
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

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter length of First and Second Linked List : Space Separated");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Node head1 = null,head2 = null;
            Node tail1 = null,tail2 = null;
            if(n>0){
                System.out.println("Please enter the elements of Linked List 1 : Space Separated");
                st = new StringTokenizer(br.readLine());
                head1 = tail1 = new Node(Integer.parseInt(st.nextToken()));
                while(n-1>0){
                    n--;
                    tail1.next = new Node(Integer.parseInt(st.nextToken()));
                    tail1 = tail1.next;
                }
            }
            if(m>0){
                System.out.println("Please enter the elements of Linked List 2 : Space Separated");
                st = new StringTokenizer(br.readLine());
                head2 = tail2 = new Node(Integer.parseInt(st.nextToken()));
                while(m-1>0){
                    m--;
                    tail2.next = new Node(Integer.parseInt(st.nextToken()));
                    tail2 = tail2.next;
                }
            }
//            System.out.println(printLL(reverseLL(head1)));
            Node res = findIntersection(head1,head2);
            System.out.println(printLL(res));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
