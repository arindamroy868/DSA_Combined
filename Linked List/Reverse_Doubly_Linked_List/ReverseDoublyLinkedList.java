import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class DoublyNode{
    int data;
    DoublyNode next = null;
    DoublyNode prev = null;
    DoublyNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data +" ";
    }
}

public class ReverseDoublyLinkedList {
    public static DoublyNode reverseDoublyLinkedList(DoublyNode head){
        if(head == null){
            return null;
        }
        DoublyNode l1 = head;
        DoublyNode l2 = head.next;
        while(true){
            l1.next = l1.prev;
            l1.prev = l2;
            if(l2 == null){
                return l1;
            }
            l1 = l2;
            l2 = l2.next;
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
