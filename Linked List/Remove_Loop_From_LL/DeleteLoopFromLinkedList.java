import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

//class Node{
//    int val;
//    public Node next = null;
//    Node(){
//
//    }
//    Node(int n){
//        val = n;
//    }
//}

public class DeleteLoopFromLinkedList {

    public static void deleteLoopFromLinkedList(Node head){
        if(head == null){
            return;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }

                // Now our slow and fast are both pointing at the node from where
                // cycle starts.
                // So now we will increment slow by one node and loop till our slow reaches the tail node
                // When slow reaches the tail node then next node of slow becomes the node where the cycle starts
                // To check that if next of slow is that cycle node or not we check if slow.next == fast
                // After we detect that slow has reached the tail node we simply set the slow.next = null;

                slow = slow.next;
                while(slow.next != fast){
                    slow = slow.next;
                }
                slow.next = null;
                break;
                // Loop removed
            }
        }
    }

    static String printLL(Node head){
        if(head == null){
            return "null";
        }
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while(curr != null){
            sb.append(curr.val+" ");
            curr = curr.next;
        }
        return sb.append("\n").toString();
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please Enter the size of LL");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            Node head = null;
            Node tail = null;

            if(n>0){
                //Initializing our LL
                head = new Node(1);
                tail = head;
                for (int i = 2; i <= n; i++) {
                    tail.next = new Node(i);
                    tail = tail.next;
                }

                //Creating loop in LL
                System.out.println("Please enter the position at which the cycle starts pos > 0");
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());

                Node curr = head;
                while(k>1){
                    curr = curr.next;
                    k--;
                }
                tail.next = curr;
            }

            // Removing Loop from LL
            long start = System.currentTimeMillis();
            deleteLoopFromLinkedList(head);
            System.out.println("After removing loop from LL -> "+printLL(head));
            long end = System.currentTimeMillis();
            System.out.println("Time elapsed = "+(end-start)+" ms");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

