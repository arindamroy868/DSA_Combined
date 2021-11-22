package Min_No_Jumps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math;

public class MinNumOfJumpsToReachEnd {

    //Time=O(N2)
    //Space=O(N)
    public static int minNumOfJumps1(int[] arr){
        if(arr.length == 0 || arr[0]==0){
            return -1;
        }
        int[] jumps = new int[arr.length];
        for(int i=1;i<jumps.length;i++){
            jumps[i] = Integer.MAX_VALUE;
        }
//        System.out.println(Arrays.toString(jumps));
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]+j>=i && jumps[j]!=Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
                }
            }
        }
//        System.out.println(Arrays.toString(jumps));
        return jumps[arr.length-1]!=Integer.MAX_VALUE?jumps[arr.length-1]:-1;

    }

    public static int minNumOfJumps2(int[] arr){
        int n = arr.length;
        if(n<=1){
            return 0;
        }
        if(arr[0]==0){
            return -1;
        }
        int maxReachable = arr[0];
        int steps = arr[0];
        int jumps = 0;

        for(int i=1;i<n;i++){
            if(i==n-1){
                return ++jumps;
            }
            maxReachable = Math.max(maxReachable,arr[i]+i);
            steps = steps-1;
            if(steps == 0){
                jumps++;
                steps = maxReachable - i;

                if(i>=maxReachable){
                    return -1;
                }

            }
        }
        return -1;
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
            System.out.println(minNumOfJumps1(arr));
            System.out.println(minNumOfJumps2(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//1 3 5 8 9 2 6 7 6 8 9
