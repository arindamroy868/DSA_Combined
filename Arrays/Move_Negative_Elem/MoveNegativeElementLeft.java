import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MoveNegativeElementLeft {

    public static void moveNegativeLeft(Integer[] nums){
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        int pos = 0;
        int curr = 0;
        while(curr<nums.length){
            if(nums[curr] < 0){
                int temp = nums[curr];
                nums[curr] = nums[pos];
                nums[pos++] = temp;
            }
            curr++;
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of array");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[n];
            if(n>0){
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Before Operation -> "+Arrays.deepToString(arr));
            moveNegativeLeft(arr);
            System.out.println("After Operation -> "+Arrays.deepToString(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
