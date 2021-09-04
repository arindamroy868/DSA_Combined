import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

//MAXIMUM Number of comparisons will be 1 + 2*(N-2)
public class MinMax {

    public static int[] minMax(int[] nums){
        int n = nums.length;
        int comparisons = 0;
        if(n == 0 ){
            return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,comparisons};
        }
        if(n == 1){
            return new int[]{nums[0],nums[0],comparisons};
        }else{
            int max,min;
            max = nums[0]>nums[1] ?nums[0] : nums[1];
            min = nums[0]>nums[1] ?nums[1] : nums[0];
            ++comparisons;
            int i = 2;
            while(i<n){
                ++comparisons;
                if(nums[i]<min){
                    min = nums[i];
                }else if(nums[i]>max){
                    ++comparisons;
                    max = nums[i];
                }
                ++i;
            }
            return new int[]{min,max,comparisons};
        }

    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter length of array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            if(n>0){
                System.out.println("Please enter ");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    nums[i] = Integer.parseInt(st.nextToken());
                }
            }
            int[] ans = minMax(nums);
            System.out.println("MINIMUM : "+ans[0]+" MAXIMUM : "+ans[1]+" COMPARISONS : "+ans[2]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
