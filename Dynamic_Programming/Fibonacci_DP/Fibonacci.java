package Fibonacci_DP;

import java.util.*;

public class Fibonacci{

    public static int fibonacci(int n,int[] dp){
        if(n == 0 || n == 1)return n;
        int a = 0;
        int b = 0;
        if(dp[n] != 0){
            return dp[n];
        }
        a = fibonacci(n-1,dp);
        b = fibonacci(n-2,dp);
        dp[n] = a+b;
        return dp[n];

    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        System.out.println(fibonacci(n,dp));
        sc.close();
    }

}