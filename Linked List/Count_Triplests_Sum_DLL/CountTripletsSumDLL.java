import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CountTripletsSumDLL {
    public static List<List<Integer>> findTripletsWithSum(DoublyNode head,int sum){
        if(head == null){
            return null;
        }
        DoublyNode a = head;
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> pairs;
        while(a.next != null){
            pairs = findPairWithSum(head.next,sum-a.data);
            if(!pairs.isEmpty()) {
                for (List<Integer> pair : pairs) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(a.data);
                    triplet.add(pair.get(0));
                    triplet.add(pair.get(1));
                    res.add(triplet);
                }
            }
            a = a.next;
        }
        return res;
    }
    public static List<List<Integer>> findPairWithSum(DoublyNode head,int sum){
        if(head == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        //T = O(n) S = O(1) approach
        DoublyNode p = head;
        DoublyNode q = head;
        while(q.next != null){
            q = q.next;
        }

        while(q!=p && q.next != p){
            if(p.data + q.data == sum){
                System.out.println("pair : "+p.data+" - "+q.data);
                List<Integer> pair = new ArrayList<>();
                pair.add(p.data);
                pair.add(q.data);
                res.add(pair);
                p = p.next;
                q = q.prev;
            }else if(p.data + q.data < sum){
                p = p.next;
            }else{
                q = q.prev;
            }
        }
        return res;
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
            System.out.println("Please enter the required sum");
            st = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken());
            System.out.println("Res -> " + findTripletsWithSum(head,sum));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
