package Revision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinChangePermutation {
    public static int coinChangePermutation(int n,int[] arr,int amt){
        if(n == 0 || arr.length == 0)return 0;
        if(amt == 0) return 1;
    
        int[] dp = new int[amt+1];
        dp[0] = 1;
        //iterating over the coins array
        for(int i=1;i<=amt;i++){
            for(int j=0;j<n;j++){
                if(arr[j]<=i){
                    dp[i] += dp[i-arr[j]];
                }
            }
        }
        return dp[amt];
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
            int amt = Integer.parseInt(st.nextToken());
            System.out.println(coinChangePermutation(n, arr, amt));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
