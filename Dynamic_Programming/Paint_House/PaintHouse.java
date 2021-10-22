import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class PaintHouse {
    public static int paintHouse(int n,int[][] costMatrix){
        if(n == 0)return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = costMatrix[0][0];
        dp[0][1] = costMatrix[0][1];
        dp[0][2] = costMatrix[0][2];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costMatrix[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costMatrix[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costMatrix[i][2];
        }
        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] costMat = new int[n][3];
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    costMat[i][0] = Integer.parseInt(st.nextToken());
                    costMat[i][1] = Integer.parseInt(st.nextToken());
                    costMat[i][2] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(paintHouse(n,costMat));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
