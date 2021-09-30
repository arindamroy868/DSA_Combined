import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class FindFirstAndLastOccurrences {
    //Time = O(log(N))
    //Space = O(1)
    public static ArrayList<Long> find(long[] arr,int n,int x){
        if(n == 0)return new ArrayList<>();
        long possible_first_pos = -1,possible_last_pos = -1;
        //Find First Pos
        int l = 0,h = n-1;
        while(l<=h){
            int mid = (h+l)/2;
            if(arr[mid] == x){
                possible_first_pos = mid;
                h = mid-1;
            }else if(arr[mid]<x){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        //Find Last Pos
        l = 0;h = n-1;
        while(l<=h){
            int mid = (h+l)/2;
            if(arr[mid] == x){
                possible_last_pos = mid;
                l = mid+1;
            }else if(arr[mid]<x){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        ArrayList<Long> res = new ArrayList<>();
        res.add(possible_first_pos);
        res.add(possible_last_pos);
        return res;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            int x = 0;
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Long.parseLong(st.nextToken());
                }
                System.out.println("Please enter element to find");
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
            }
            System.out.println(find(arr,n,x));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
