package Buy_And_Sell_Stock_Once;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class BuyAndSellStockOnce {
    public static int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        int max_profit = 0;

        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            max_profit = Math.max(max_profit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max_profit;
    }
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter the number of days");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n>0){
                int[] prices = new int[n];
                System.out.println("Please enter the prices");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    prices[i] = Integer.parseInt(st.nextToken());
                }
                System.out.println(maxProfit(prices));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
