import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountBinaryStrings {
    public static int countStrings(int n){
        if(n == 0)return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i-1][0] = dp[i-2][1];
            dp[i-1][1] = dp[i-2][0] + dp[i-2][1];
        }
        return dp[n-1][0] + dp[n-1][1];
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(countStrings(n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
