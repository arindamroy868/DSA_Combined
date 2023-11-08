package Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TargetSum {
    public static boolean targetSumDp(int n,int[] arr,int tar){
        if(n==0){
            if(tar == 0)return true;
            else return false;
        }
        boolean[][] dp = new boolean[n+1][tar+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=tar;j++){
                if(j == 0)dp[i][j] = true;

                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][tar];
    }
     public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int tar = Integer.parseInt(st.nextToken());
            System.out.println(targetSumDp(n, arr, tar));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     }
}
