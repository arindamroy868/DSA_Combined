package Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountBinary {
    public static int countBinary(int n){
        if(n==0)return 0;
        int[][] dp = new int[2][n+1];
        dp[0][1] = 1;
        dp[1][1] = 1;

        for(int i = 2;i<=n;i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
        }
        return dp[1][n] + dp[0][n];
    }
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(countBinary(n));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
