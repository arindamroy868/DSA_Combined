package Min_Cost_Maze_Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MinCostMazeTraversal {
    //Top to Bottom Approach
    //dp[i][j] represents the minimum cost to reach the cell arr[i][j]
    //Time = O(N*N)
    //Space = O(N*N)
    public static int minCostTopDown(int[][] arr){
        int n = arr.length;
        if(n == 0)return 0;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        //Setting minimum cost to reach first cell is the cost of cell
        dp[0][0] = arr[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j == 0)continue;
                int a = j-1>=0?dp[i][j-1]:Integer.MAX_VALUE;
                int b = i-1>=0?dp[i-1][j]:Integer.MAX_VALUE;
                dp[i][j] = Math.min(a,b)+arr[i][j];
            }
        }
        return dp[n-1][m-1];
    }
    //Bottom to Top Approach
    //dp[i][j] represents the minimum cost to reach the destination from cell arr[i][j]
    //Time = O(N*N)
    //Space = O(N*N)
    public static int minCostBottomUp(int[][] arr){
        int n = arr.length;
        if(n == 0)return 0;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        //Setting minimum cost to reach first cell is the cost of cell
        dp[n-1][m-1] = arr[n-1][m-1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 && j == m-1)continue;
                int a = j+1<m?dp[i][j+1]:Integer.MAX_VALUE;
                int b = i+1<n?dp[i+1][j]:Integer.MAX_VALUE;
                dp[i][j] = Math.min(a,b)+arr[i][j];
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter row and column of Matrix");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            if (n > 0) {
                System.out.println("Please enter elements of matrix");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    for(int j=0;j<m;j++){
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println(minCostTopDown(arr));
            System.out.println(minCostBottomUp(arr));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
