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

public class RemoveDuplicatesFromUnsortedLinkedList {
    public static Node removeDuplicates(Node head){
        if(head == null){
            return head;
        }
        Node curr = head;

        HashSet<Integer> hs = new HashSet<>();
        while(curr.next != null){
            hs.add(curr.val);
            if(hs.contains(curr.next.val)){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
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
            System.out.println("Please enter the size of LL");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            Node head = null;
            Node tail = null;
            if(n>0){
                System.out.println("Please enter elements of LL");
                st = new StringTokenizer(br.readLine());
                head = new Node(Integer.parseInt(st.nextToken()));
                tail = head;
                //Initializing LL
                while(n>1) {
                    tail.next = new Node(Integer.parseInt(st.nextToken()));
                    tail = tail.next;
                    n--;
                }
            }

            System.out.println("LL Before Removal");
            System.out.println(printLL(head));
            System.out.println("LL After Removal");
            System.out.println(printLL(removeDuplicates(head)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
