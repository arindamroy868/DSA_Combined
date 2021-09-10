import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CountPairsWithGivenSum {
    //Time=O(N2)
    //Space=O(1)
    public static List<List<Integer>> findSumPairs(int[] arr,int sum){
        int n = arr.length;
        if(n == 0 || n == 1){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i]+arr[j] == sum){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(arr[i]);
                    ans.add(arr[j]);
                    res.add(ans);
                }
            }
        }
        return res;
    }

    //Time=O(N)
    //Space=O(N)
    //Using Hashing
    public static List<List<Integer>> findSumPairs2(int[] arr,int sum){
        int n = arr.length;
        if(n == 0 || n == 1){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> hs = new HashMap<>();

        for(int i=0;i<n;i++){
            if(hs.containsKey(sum-arr[i])){
                int dups = hs.get(sum-arr[i]);
                while(dups>0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(sum-arr[i]);
                    ans.add(arr[i]);
                    res.add(ans);
                    --dups;
                }
            }
            if(hs.containsKey(arr[i])){
                hs.put(arr[i],hs.get(arr[i])+1);
            }else{
                hs.put(arr[i],1);
            }
        }
        return  res;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int sum = 0;
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                System.out.println("Enter required sum value");
                st = new StringTokenizer(br.readLine());
                sum = Integer.parseInt(st.nextToken());
            }
            System.out.println(findSumPairs(arr,sum));
            System.out.println(findSumPairs2(arr,sum));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
