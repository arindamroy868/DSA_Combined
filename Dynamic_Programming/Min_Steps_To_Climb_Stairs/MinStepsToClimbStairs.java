package Min_Steps_To_Climb_Stairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MinStepsToClimbStairs {
    //Iterative/Tabulation Method
    //Time = O(N*N)
    //Space = O(N) for tabulation
    public static int minStepsToClimbStairs(int n,int[] arr){
        if(n == 0)return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            if(arr[i] !=0){
                int min = Integer.MAX_VALUE;
                int steps = arr[i];
                for(int j=1;j<=steps && i+j<n;j++){
                    min = Math.min(min,dp[i+j]);
                }
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(minStepsToClimbStairs(n,arr));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
