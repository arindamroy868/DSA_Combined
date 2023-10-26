import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CheckPalindrome {
    public static boolean isPalindrome(String s){
        int i = 0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++) != s.charAt(j++)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
