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

public class ReverseLinkedList {
    public static Node reverseLLRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node rest = reverseLLRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void printLL(Node head){
        while(head !=null){
            System.out.print(head.data +" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            Node tail = new Node(1);
            Node head = tail;
            for (int i = 2; i <= n; i++) {
                tail.next = new Node(i);
                tail = tail.next;
            }
            System.out.println("Before Reversal");
            printLL(head);
            System.out.println("After Reversal");
            printLL(reverseLLRecursive(head));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
