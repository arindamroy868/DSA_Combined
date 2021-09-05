import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class RotateClockwiseByKNodesDLL {
    public static DoublyNode rotateClockwiseByKNodes(DoublyNode head,int k){
        if(head == null){
            return null;
        }
        //Finding the length of DLL
        int DLLSize = 0;
        DoublyNode curr = head;
        while(curr!=null){
            curr = curr.next;
            DLLSize++;
        }
        //If K>=DLLSize
        k = k%DLLSize;
        //Traversing to the breakpoint
        if(k != 0){
            DoublyNode breakPoint = head;
            while(--k>0){
                breakPoint= breakPoint.next;
            }
            DoublyNode tail = breakPoint.next;
            while(tail!=null && tail.next!=null){
                tail = tail.next;
            }
            if(tail!= null){
                tail.next = head;
                head = breakPoint.next;
                breakPoint.next = null;
                head.prev = null;
            }
        }
        return head;
    }

    public static DoublyNode addLast(DoublyNode head,int data){
        DoublyNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        DoublyNode newNode = new DoublyNode(data);
        newNode.prev = tail;
        tail.next = newNode;
        return head;
    }


    static String printLL(DoublyNode head) {
        if (head == null) {
            return "null";
        }
        DoublyNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.data + " ");
            curr = curr.next;
        }
        return sb.append("\n").toString();
    }


    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of doubly linked list");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            DoublyNode head = null;

            if(n > 0){
                System.out.println("Please enter the elements of DLL");
                st = new StringTokenizer(br.readLine());
                head = new DoublyNode(Integer.parseInt(st.nextToken()));
                while(--n>0){
                    head = addLast(head,Integer.parseInt(st.nextToken()));
                }
            }
            System.out.println("DLL -> " + printLL(head));
            System.out.println("Please enter kth value");
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            head = rotateClockwiseByKNodes(head,k);
            System.out.println("Res -> " + printLL(head));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
