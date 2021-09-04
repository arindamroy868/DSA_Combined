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

public class FindStartingPointOfLoop {
    public static Node findStartingOfLoop(Node head){
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
                return fast;
            }
        }
        return null;
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
                head = new Node(1);
                tail = head;
                for (int i = 2; i <= n; i++) {
                    tail.next = new Node(i);
                    tail = tail.next;
                }
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
            Node ans =  findStartingOfLoop(head);
            if(ans != null){
                System.out.println("Loop Found at Element " + ans.data);
            }else{
                System.out.println(-1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
