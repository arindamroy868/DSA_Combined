package Revision;

import java.io.*;
import java.util.*;

public class MinCostMazeTravel {

    public static int minCostMazeTravel(int n,int m,int[][] arr){
        if(n == 0 || m == 0)return -1;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = arr[n-1][m-1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int down=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                if(dp[i][j] == 0){
                    if(i+1<n)down = arr[i][j]+dp[i+1][j];
                    if(j+1<m)right = arr[i][j]+dp[i][j+1];
                    dp[i][j] = Math.min(down,right);
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(minCostMazeTravel(n,m,mat));
    }

}