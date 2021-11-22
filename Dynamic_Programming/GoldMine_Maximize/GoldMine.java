package GoldMine_Maximize;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class GoldMine {
    public static int maximizeGold(int[][] arr){
        int n = arr.length;
        if(n == 0)return 0;
        int m = arr[0].length;
        int[][] dp = new int[n][m];

        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                int rightUp = j+1<m && i-1>=0?dp[i-1][j+1]:0;
                int right = j+1<m?dp[i][j+1]:0;
                int rightDown = j+1<m && i+1<n?dp[i+1][j+1]:0;
                dp[i][j] = Math.max(right,Math.max(rightUp,rightDown)) + arr[i][j];
            }
        }
        int maxGold = -1;
        for(int i=0;i<n;i++){
            maxGold = Math.max(maxGold,dp[i][0]);
        }
        return maxGold;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer((br.readLine()));
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j=0;j<m;j++){
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println(Arrays.deepToString(arr));
            System.out.println(maximizeGold(arr));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
*/
