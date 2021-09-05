import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CheckPalindromeLinkedList {
    public static boolean isPalindrome(Node head)
    {
        //Divide the linked list in two parts first
        //Start to Mid element will be first part
        //Mid+1 to end element will be second part
        //eg: 1->2->3->2->1 is our linked list
        //so head->1->2->3 will be first part and
        //head2->2->1 will be second part
        Node mid = findMid(head);

        //Creating head to the second part of linked list
        Node head2 = mid.next;
        //breaking link between two lists
        //head->1->2->3--XXX--head2->2->1
        mid.next = null;
        //Reversing the second linked list
        head2 = reverseLLRecursive(head2);

        //We take two pointers for both LL
        //We check if the node data is equal or not till one of the pointer reaches null
        //If no difference encountered then the original ll is a palindrome
        //Else if any difference is noticed between two pointers then the loop will break and return false
        while(head!=null && head2!=null){
            if(head.data != head2.data){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        if(head == null){
            return null;
        }

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node reverseLLRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node rest = reverseLLRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
    public static Node addLast(Node head,int data){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = new Node(data);
        return head;
    }

    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of linked list");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node head = null;
            if(n>0){
                System.out.println("Please enter elements of linked list");
                st = new StringTokenizer(br.readLine());
                head = new Node(Integer.parseInt(st.nextToken()));
                while(--n>0){
                    head = addLast(head,Integer.parseInt(st.nextToken()));
                }
            }
            System.out.println(isPalindrome(head));
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
