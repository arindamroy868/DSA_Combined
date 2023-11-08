package Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        dp.add(row);
        
        for(int i=1;i<numRows;i++){
            row = new ArrayList<>();
            int lastRowSize = dp.get(dp.size() - 1).size();
            for(int j=0;j<=lastRowSize;j++){
                int left = j-1>=0?dp.get(dp.size()-1).get(j-1):0;
                int right = j<lastRowSize?dp.get(dp.size()-1).get(j):0;
                row.add(left+right);
            }
            dp.add(row);
        }
        return dp;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        System.out.println(generate(n));
    }
}
