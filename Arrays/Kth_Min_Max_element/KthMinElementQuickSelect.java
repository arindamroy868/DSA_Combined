package Kth_Min_Max_element;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class KthMinElementQuickSelect {

    public static int partition(int[] arr,int l,int h){
        int j = l;
        int i = l-1;
        int pivot = arr[h];
        while(j<=h){
            if(arr[j]<=pivot){
                int temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        return i;
    }

    public static int kthMinElement(int[] arr,int l,int h,int k){
        int n = arr.length;
        if(k>n){
            return -1;
        }
        //Partitions the array in 2 halves
        //Left subarray will be smaller than pivot
        //Right subarray will be larger than pivot
        int partition = partition(arr,l,h);

        if(partition == k-1){
            return arr[partition];
        }
        else if(partition < k){
            return kthMinElement(arr,partition+1,h,k);
        }else{
            return kthMinElement(arr,l,partition-1,k);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int k = Integer.MAX_VALUE;
            if (n > 0) {
                System.out.println("Please enter the elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                System.out.println("Please enter value of K");
                st = new StringTokenizer(br.readLine());
                k = Integer.parseInt(st.nextToken());
            }
            System.out.println(kthMinElement(arr,0,n-1,k));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
