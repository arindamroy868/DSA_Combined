package Min_Cost_Climb_Stairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinCostClimbStairs {
    public static int minCostClimbingStairs(int[] cost){
        if(cost.length == 0)return 0;
        int n = cost.length;
        for(int i=n-1;i>=0;i--){
            int oneJump = i+1<n?cost[i+1]:0;
            int twoJump = i+2<n?cost[i+2]:0;
            cost[i] += Math.min(oneJump,twoJump);
        }
        return cost.length>1?Math.min(cost[0],cost[1]):cost[0];
    }
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] cost = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                cost[i] = Integer.parseInt(st.nextToken());    
            }
            System.out.println(minCostClimbingStairs(cost));  
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
