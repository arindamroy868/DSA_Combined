import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class KCyclicRotate {
    //Time=O(N2)
    //Space=O(1)
    public static void cyclicRotateByKTimesMethod1(Integer[] arr,int k){
        if(arr.length == 0 || arr.length == 1){
            return;
        }
        k = k%arr.length;
        while(k>0){
            int firstElement = arr[0];
            for(int i=0;i<arr.length-1;i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = firstElement;
            k--;
        }
    }

    public static void reverseArray(Integer[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    //Time=O(N)
    //Space=O(1)
    public static void cyclicRotateByKTimesMethod2(Integer[] arr,int k){
        if(arr.length == 0 || arr.length == 1){
            return;
        }
        int n = arr.length;
        k = k%n;
        reverseArray(arr,0,n-1);
        reverseArray(arr,0,n-k-1);
        reverseArray(arr,n-k,n-1);
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[n];
            int k = 0;
            if(n>0){
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                System.out.println("Please enter the value of K");
                st = new StringTokenizer(br.readLine());
                k = Integer.parseInt(st.nextToken());
            }
            System.out.println("Before rotate -> "+Arrays.deepToString(arr));
            cyclicRotateByKTimesMethod2(arr,k);
            System.out.println("After rotate -> "+Arrays.deepToString(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
