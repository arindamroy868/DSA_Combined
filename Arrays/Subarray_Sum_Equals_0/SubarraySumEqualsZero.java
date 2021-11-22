package Subarray_Sum_Equals_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class SubarraySumEqualsZero {

    //Naive Approach - Generate all Sub-Arrays and check if the Sub-Array's sum is zero or not
    //Time=O(N2)
    //Space=O(1)
    public static boolean subArrayExists1(int[] arr){
        if(arr.length == 0) return false;
        int n = arr.length;
        int i;
        for(i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum == 0){
                    return true;
                }
            }
        }
        return false;

    }

    public  static boolean subArrayExists2(int[] arr){
        if(arr.length == 0)return false;
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum +=arr[i];
            if(sum == 0){
                return true;
            }
            if(hs.contains(sum)){
                return true;
            }
            hs.add(sum);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(subArrayExists1(arr));
            System.out.println(subArrayExists2(arr));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
