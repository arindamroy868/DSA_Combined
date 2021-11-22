package Subarray_Sum_Equals_0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

//This problem is a modification to the Subarray Problem
//To find the subarray with sum 0
//This one is to find subarray with sum K
public class SubarraySumEqualsK {
    public static int subArrayWithSumK(int[] nums,int k){
        if(nums.length == 0)return -1;
        int n = nums.length;

        ArrayList<Integer> res  = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int continuousSum = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            continuousSum+=nums[i];
            if(continuousSum == k){
                count++;
            }
            if(hm.containsKey(continuousSum - k)){
                count += hm.get(continuousSum-k);
            }


            if(hm.containsKey(continuousSum)){
                hm.put((continuousSum),hm.get(continuousSum)+1);
            }else{
                hm.put(continuousSum,1);
            }
        }
        return count;
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
            System.out.println("Please enter the value of K");
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(subArrayWithSumK(arr,k));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
