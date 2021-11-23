package Climb_Stairs_With_Variable_Jumps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ClimbStairsWithVariableJumps {
    //Recursive Method
    //Time = O(N*N)
    //Space = O(N)
    public static int climbStairs(int i,int n,int[] arr,int[] dp){
        if(i == n)return 1;
        if(arr[i] == 0)return 0;
        int steps = Math.min(n-i,arr[i]);
        int possPath = 0;
        for(int j=1;j<=steps;j++){
            possPath+= climbStairs(i+j,n,arr,dp);
        }
        dp[i] = possPath;
        return dp[i];
    }
    //Iterative Method
    //Time = O(N*N)
    //Space = O(N)
    public static int climbStairsIterative(int n,int[] arr){
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            int possPaths = 0;
            for(int j=1;j<=Math.min(n-i,arr[i]);j++){
                possPaths+=dp[i+j];
            }
            dp[i] = possPaths;
        }
        return dp[0];
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
            System.out.println("Total Paths : "+climbStairs(0,n,arr,new int[n]));
            System.out.println("Total Paths : "+climbStairsIterative(n,arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//10
//3 3 0 2 1 2 4 2 0 0