import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MaxCommonSubsequence {
    public static int maxCommonSubsequence(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        if(n == 0 || m == 0){
            return 0;
        }
        int[][] dp = new int[n+1][m+1];
        for(int r=1;r<=n;r++){
            for(int c=1;c<=m;c++){
                if(s1.charAt(r-1) == s2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1] +1;
                }else{
                    dp[r][c] = Math.max(dp[r-1][c],dp[r][c-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter String 1");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            System.out.println("Please enter String 1");
            st = new StringTokenizer(br.readLine());
            String s2 = st.nextToken();
            System.out.println(maxCommonSubsequence(s1,s2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
