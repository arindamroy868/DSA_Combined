import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String s){
        if(s == null)return "";
        if(s.length() == 1)return s.substring(0,1);

        int n = s.length();
        int i = 0;
        int[] res = new int[]{0,0};
        while(i<n){
            //Check for Longest Palindrome with i as center
            int[] odd = longestOddLengthPalindrome(s,i,n);
            if((odd[1]-odd[0]+1) > (res[1]-res[0]+1)){
                res = odd;
            }
            //Check for Longest Palindrome with i and i+1 as center
            int[] even = longestEvenLengthPalindrome(s,i,n);
            if((even[1]-even[0]+1) > (res[1]-res[0]+1)){
                res = even;
            }
            i++;
        }
        return s.substring(res[0],res[1]+1);
    }
    public static int[] longestOddLengthPalindrome(String s,int i,int n){
        int maxLength = 1;
        int j = i-1,k=i+1;
        while(j>=0 && k<n){
            if(s.charAt(j) == s.charAt(k)){
                maxLength += 2;
                j--;k++;
            }else{
                break;
            }
        }
        return new int[]{j+1,k-1};
    }
    public static int[] longestEvenLengthPalindrome(String s,int i,int n){
        int maxLength = 0;
        int j = i,k=i+1;
        while(j>=0 && k<n){
            if(s.charAt(j) == s.charAt(k)){
                maxLength += 2;
                j--;k++;
            }else{
                break;
            }
        }
        return new int[]{j+1,k-1};
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter String");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            System.out.println(longestPalindromicSubstring(s));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
