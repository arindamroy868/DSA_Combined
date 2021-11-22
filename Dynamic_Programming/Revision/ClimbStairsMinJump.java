package Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClimbStairsMinJump {
    //Time = O(N2)
    //Space = O(N)
    public static int climbStairsMinJump(int n,int[] arr){
        if(n == 0)return -1;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            if(arr[i] == 0){
                dp[i] = Integer.MAX_VALUE;
            }else{
                int minJumps = Integer.MAX_VALUE;
                for(int j=1;j<=arr[i] && i+j<=n;j++){
                    minJumps = Math.min(minJumps,dp[i+j]==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[i+j]+1);
                }
                dp[i] = minJumps;
            }
        }
        return dp[0]==Integer.MAX_VALUE?-1:dp[0];
    }
    //Time = O(N)
    //Space = O(1)
    public static int climbStairsMinJumps2(int n,int[] arr){
        if(n==0)return -1;
        if(arr[0] == 0)return -1;
        int maxReachable=arr[0],jumps=1,steps=arr[0];
        for(int i=1;i<n;i++){
            maxReachable = Integer.max(maxReachable,i+arr[i]);
            if(maxReachable >= n)return jumps+1;
            steps--;
            if(steps <= 0){
                steps = arr[i];
                jumps++;
            }
        }
        return -1;
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
            System.out.println(climbStairsMinJump(n,arr));
            System.out.println(climbStairsMinJumps2(n,arr));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
