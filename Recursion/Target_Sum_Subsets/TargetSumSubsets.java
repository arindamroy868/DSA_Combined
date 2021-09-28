import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class TargetSumSubsets {
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        int n = arr.length;
        if(sos == tar){
            System.out.println(set.trim());
            return;
        }
        if(idx >= n || sos > tar){
            return;
        }
        printTargetSumSubsets(arr,idx+1,set+" "+arr[idx],sos+arr[idx],tar);
        printTargetSumSubsets(arr,idx+1,set,sos,tar);
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int tar = 0;
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                System.out.println("Please enter the target sum");
                st = new StringTokenizer(br.readLine());
                tar = Integer.parseInt(st.nextToken());
            }
            printTargetSumSubsets(arr,0,"",0,tar);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
