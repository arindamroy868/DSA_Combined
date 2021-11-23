package Count_Encodings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountEncodings {
    public static boolean encode(String str){
        if(str.length() == 1){
            int s = Integer.parseInt(str);
            return s>=1 && s<=26;
        }else{
            if(str.charAt(0) == '0'){
                return false;
            }else{
                int s = Integer.parseInt(str);
                return s >=1 & s <=26;
            }
        }

    }
    public static int countEncodings(String str){
        if(str.length() == 0)return 0;
        int n = str.length();
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n;i++){
            int sum = 0;
            if(encode(str.substring(i,i+1))){
                sum += dp[i-1];
            }
            if(encode(str.substring(i-1,i+1))){
                sum += i>=2?dp[i-2]:1;
            }
            dp[i] = sum;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            System.out.println(countEncodings(str));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
