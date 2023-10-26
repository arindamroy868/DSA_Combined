import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class All_Possible_Subsequences {
    static List<String> powerSet = new ArrayList<>();
    //Time = O(2^n)
    //Space = O(N)
    public static void allPossibleSubsequences(String s,String res){
        if(s.length() == 0){
            powerSet.add(res);
        }
        else{
            allPossibleSubsequences(s.substring(1),res+s.charAt(0));
            allPossibleSubsequences(s.substring(1),res);
        }
    }
    //Time = O(2^N * N)
    //Space = O(1)
    public static void allPossibleSubsequences2(String s){
        if(s.length() == 0)return;
        int n = s.length();
        for(int i = 0;i<Math.pow(2,n);i++){
            int j = 0;
            StringBuilder sb = new StringBuilder();
            int x = i;
            while(j<n){
                if((x&1) != 0){
                    sb.append(s.charAt(j));
                }
                x = x>>1;
                j++;
            }
            powerSet.add(sb.toString());
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter string");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
//            allPossibleSubsequences(s,"");
            allPossibleSubsequences2(s);
            System.out.println(powerSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
