package Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClimbStairsVariableJump {
    public static int climbStairsVariableJump(int n,int[] arr){
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            int paths = 0;
            for(int j=0;j<=arr[i] && i+j<=n;j++){
                paths+=dp[i+j];
            }
            dp[i] = paths;
        }
        return dp[0];
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
            System.out.println(climbStairsVariableJump(n,arr));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
