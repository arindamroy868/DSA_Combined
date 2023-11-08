package Target_Sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TargetSum {
    public static boolean targetSum(int[] arr,int tar){
        if(arr.length == 0){
            return tar == 0;
        }
        int n =  arr.length;
        boolean[][] dp = new boolean[n+1][tar+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=tar;j++){
                if(i == 0){
                    dp[i][j] = j == 0;
                }
                else if(j == 0){
                        dp[i][j] = true;
                }else{
                    int val = arr[i-1];
                    if(j>=val){
                        dp[i][j] = dp[i-1][j-val];
                    }
                    dp[i][j] = dp[i-1][j] || dp[i][j];
                }
            }
        }
        return dp[n][tar];
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int tar = 0;
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(br.readLine());
                tar = Integer.parseInt(st.nextToken());
            }
            System.out.println(targetSum(arr,tar));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
