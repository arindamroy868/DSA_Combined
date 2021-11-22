package ZeroOneKnapsack;

import java.io.*;
import java.util.*;

public class ZeroOneKnapsack {
    public static int zeroOneKnapsack(int[] weights,int[] values,int x){
        if(x == 0 || weights.length == 0)return 0;
        int n = weights.length;
        int[][] dp = new int[n+1][x+1];
        for(int i = 1;i <= n;i++){
            for(int j = 0;j <= x;j++){
                if(j == 0)dp[i][j] = 0;
                else if(weights[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]] + values[i-1]);
                }
            }

        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][x];
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for(int i=0;i<n;i++){
            values[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            weights[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        System.out.println(zeroOneKnapsack(weights,values,cap));
    }
}