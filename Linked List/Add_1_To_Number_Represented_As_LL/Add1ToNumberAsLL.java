import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Add1ToNumberAsLL {

    public static int add1toLL(Node current){

        if(current == null){
            return 1;
        }
        //If we are not at the last node then we recursively call the function to get carry
        int carry = add1toLL(current.next);
        current.data += carry;
        carry = current.data /10;
        current.data %= 10;
        return carry;
    }

    public static Node addOne(Node head)
    {
        int carry = add1toLL(head);
        if(carry == 1 && head != null){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
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
            System.out.println("Please enter size of linked list");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node head = null;
            Node tail = null;
            if(n>0){
                System.out.println("Please enter the elements of linked list in a single line space separated");
                st = new StringTokenizer(br.readLine());
                head = new Node(Integer.parseInt(st.nextToken()));
                tail = head;
                for (int i = 1; i < n; i++) {
                    Integer x = Integer.parseInt(st.nextToken());
                    Node nN = new Node(x);
                    tail.next = nN;
                }
            }
            head = addOne(head);
            System.out.println("Linked List after operation -> " +printLL(head));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
