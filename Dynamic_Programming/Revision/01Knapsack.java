package Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Knapsack01{
    public static int Knapsack(int n,int cap,int[] values,int[] weights){
        if(cap == 0 || n == 0 )return 0;
        int[][] dp = new int[n+1][cap+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){
                if(weights[i-1] >j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]]);
                }
            }
        }
        return dp[n][cap];
    }


    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] values = new int[n];
            int[] weights = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                values[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                weights[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int cap = Integer.parseInt(st.nextToken());
            System.out.println(Knapsack(n, cap, values, weights));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
}