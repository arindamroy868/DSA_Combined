import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

//Time = O(Max(N,M))
//Space = O(Max(N,M)) can be done in O(1) if mutation is allowed
public class AddTwoLinkedList {
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

    public static Node addTwoLinkedList(Node head1,Node head2) {
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }

        head1 = reverseLL(head1);
        head2 = reverseLL(head2);

        Node head = null;
        Node c1=head1,c2=head2;
        int sum = 0;
        int carry = 0;

        while(c1 != null && c2 != null){
            sum = c1.data + c2.data + carry;
            carry = sum/10;
            sum = sum%10;
            head = addNode(head,sum);
            c1 = c1.next;
            c2 = c2.next;
        }

        while(c1 != null){
            sum = c1.data + carry;
            carry = sum/10;
            sum = sum%10;
            head = addNode(head,sum);
            c1 = c1.next;
        }
        while(c2 != null){
            sum = c2.data + carry;
            carry = sum/10;
            sum = sum%10;
            head = addNode(head,sum);
            c2 = c2.next;
        }

        if(carry>0){
            head = addNode(head,carry);
        }
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
            Node res = addTwoLinkedList(head1,head2);
            System.out.println(printLL(res));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
