package Paint_House_Many_Colors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class PaintHouseManyColors {
    public static int paintHouse(int n,int k,int[][] costMatrix){
        if(n == 0)return 0;
        int[][] dp = new int[n][k];
        System.arraycopy(costMatrix[0], 0, dp[0], 0, k);
        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                int min = Integer.MAX_VALUE;
                for(int x=0;x<k;x++){
                    if(x!=j) min = Math.min(min,dp[i-1][x]);
                }
                dp[i][j] = min + costMatrix[i][j];
            }   
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<k;i++) min = Math.min(min,dp[n-1][i]);
        return min;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] costMat = new int[n][k];
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j=0;j<k;j++){
                        costMat[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println(paintHouse(n,k,costMat));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
