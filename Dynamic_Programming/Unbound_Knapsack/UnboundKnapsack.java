package Unbound_Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnboundKnapsack {
    public static int unboundKnapsack(int[] values,int[] weights,int cap){
        if(cap == 0 || values.length == 0)return 0;
        int n = values.length;
        int[] dp = new int[cap+1];

        for(int i=1;i<=cap;i++){
            for(int j=0;j<n;j++) {
                int weight = weights[j];
                if (weight <= i) {
                    dp[i] = Math.max(dp[i], values[j] + dp[i - weight]);
                }
            }
        }
        return dp[cap];
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
            System.out.println(unboundKnapsack(values,weights,cap));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
