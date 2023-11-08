package Max_Rectangle_In_Histogram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MaxRectangleInHistogram {
    public static int calArea(ArrayDeque stack,int top,int i,long[] arr){
        if(stack.isEmpty()){
            return (int)arr[top]*i;
        }else{
            return (int)arr[top]*(i-1-(int)stack.peek());
        }
    }
    public static int maxRectangleInHistogram(long[] arr,long n){
        if(n==0){
            return 0;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>(0);
        int i=0;
        int maxArea = 0;
        while(i<n){
            if(!stack.isEmpty()){
                if(arr[stack.peek()] > arr[i]){
                    while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                        int top = stack.pop();
                        int area = calArea(stack,top,i,arr);
                        maxArea = Math.max(area,maxArea);
                    }
                }else{
                    stack.push(i++);
                }
            }else{
                stack.push(i++);
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            int area = calArea(stack,top,i,arr);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;

    }
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter length of array");
//            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = sc.nextInt();
            long[] arr = new long[n];
            if (n > 0) {
//                System.out.println("Please enter elements of array");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
            }
            System.out.println(maxRectangleInHistogram(arr,n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
