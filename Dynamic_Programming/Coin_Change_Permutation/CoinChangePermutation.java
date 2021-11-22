package Coin_Change_Permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CoinChangePermutation {
    public static int coinChangePermutation(int[] arr,int n,int tar){
        if(n == 0)return 0;
        int[] dp = new int[tar+1];
        dp[0] = 1;
        Arrays.sort(arr);
        for(int i=1;i<=tar;i++){
            for(int j=0;j<n;j++){
                int coin = arr[j];
                if(coin<=i){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[tar];
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            int tar = Integer.parseInt(st.nextToken());
            System.out.println(coinChangePermutation(arr,n,tar));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
