package Count_Inversion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CountInversion {
    static long count = 0;
    public static long countInversion(long[] arr){
        mergeSort(arr,0,arr.length-1);
        return count;
    }

    public static void mergeSort(long[] arr,int l,int h){
        if(l>=h){
            return;
        }
        int m = (l+h)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,h);
        merge(arr,l,h,m);
    }

    public static void merge(long[] arr,int l,int h,int m){
        int k = 0;
        long[] a = new long[m-l+1];
        long[] b = new long[h-m];

        for(int i=0;i<a.length;i++){
            a[i] = arr[l+i];
        }
        for(int i=0;i<b.length;i++){
            b[i] = arr[m+i+1];
        }

        int i=0,j=0;

        while(i<a.length && j<b.length){
            if(a[i]>b[j]){
                count+=a.length - i;
                arr[l+k++] = b[j++];
            }else{
                arr[l+k++] = a[i++];
            }
        }
        while(i<a.length){
            arr[l + k++] = a[i++];
        }

        while(j<b.length){
            arr[l+k++] = b[j++];
        }
    }



    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            if(n>0){
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Long.parseLong(st.nextToken());
                }
            }
            System.out.println("Before sorting : "+Arrays.toString(arr));
            System.out.println("Total Inversions : "+countInversion(arr));
            System.out.println("After sorting : "+Arrays.toString(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
