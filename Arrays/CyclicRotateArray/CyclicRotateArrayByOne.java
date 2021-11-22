package CyclicRotateArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CyclicRotateArrayByOne {
    public static void cyclicRotateByOne(Integer[] arr){
        if(arr.length == 0 || arr.length == 1){
            return;
        }
        int firstElement = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = firstElement;
    }
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[n];
            if(n>0){
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Before rotate -> "+Arrays.deepToString(arr));
            cyclicRotateByOne(arr);
            System.out.println("After rotate -> "+Arrays.deepToString(arr));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
