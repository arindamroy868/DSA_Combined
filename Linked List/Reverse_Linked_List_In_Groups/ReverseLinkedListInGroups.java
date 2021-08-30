import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


//Time Complexity = O(N)
//Space Complexity = O(N/K)

public class ReverseLinkedListInGroups {

    public static Node reverseLinkedListInGroups(Node head, int groupSize){
        if(head == null){
            return null;
        }

        Node p = null;
        Node c = head,n = head;
        int k = groupSize;
        while(k>0 && c != null){
            n = n.next;
            c.next = p;
            p = c;
            c = n;
            k--;
        }
        Node nextHead = reverseLinkedListInGroups(c,groupSize);
        head.next = nextHead;
        return p;
    }

    public static void printLL(Node head){
        while(head !=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter linkedlist size");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node tail = new Node(1);
            Node head = tail;
            for (int i = 2; i <= n; i++) {
                tail.next = new Node(i);
                tail = tail.next;
            }
            System.out.println("Please enter group size");
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            System.out.println("Before Reversal");
            printLL(head);
            System.out.println("After Reversal");
            printLL(reverseLinkedListInGroups(head,k));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
