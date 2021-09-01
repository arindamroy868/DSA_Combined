import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;

//By $TR!NG

public class ReverseArray2 {

    public static void reverseArray(int[] arr){
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(i<j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter the size of array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if(n>0){
                System.out.println("Please enter the elements of array separated by space");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Original Array");
            System.out.println(Arrays.toString(arr));
            System.out.println("After reversing");
            reverseArray(arr);
            System.out.println(Arrays.toString(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
