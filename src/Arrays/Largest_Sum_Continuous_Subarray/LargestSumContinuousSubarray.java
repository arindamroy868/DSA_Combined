package Largest_Sum_Continuous_Subarray;

import java.util.Arrays;

public class LargestSumContinuousSubarray {
    //Returns Shortest Contiguous subarray with maximum sum
    public static int[] largestSumContinuousSubarray(int[] a){
        if(a.length == 0 || a == null){
            return new int[]{-1,-1,-1};
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int shortestLen = Integer.MAX_VALUE;
        int start=0,end=0;
        int[] res = new int[3];

        for(int i=0;i<a.length;i++){
            sum+=a[i];
            end = i;
            if(sum >=0){
                if(max<sum){
                    max = sum;
                    shortestLen = (end-start)+1;
                    res[0] = start;
                    res[1] = end;
                    res[2] = max;
                }else if(max == sum) {
                    if (shortestLen > (end - start)+1) {
                        res[0] = start;
                        res[1] = end;
                    }
                }

            }
            else{
                max = Math.max(max,a[i]);
                sum = 0;
                start = end = i+1;
            }
        }
        res[2] = max;
        return  res;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{3,4,-2,-1,2,-7,5,1,1,1};
                int[] a = new int[]{-10,-9,-8,-7,-6,-5,-4};
        System.out.println(Arrays.toString(largestSumContinuousSubarray(a)));
    }
}
