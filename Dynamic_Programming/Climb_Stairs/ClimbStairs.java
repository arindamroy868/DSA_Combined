package Climb_Stairs;

import java.io.*;
import java.util.*;

public class ClimbStairs {
    public static int climbStairs(int i,int n,int[] dp){
        int paths = 0 ;
        if(i == n){
            paths = 1;
        }
        else if(i > n){
            paths = 0;
        }
        else if(dp[i] != 0){
            paths = dp[i];
        }
        else {
            for(int steps=1;steps<=3;steps++){
                paths+=climbStairs(i+steps,n,dp);
                dp[i] = paths;
            }
        }
        return paths;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        System.out.println(climbStairs(0,n,dp));
    }

}