package IsSubsequence;

import java.util.Scanner;

public class IsSubsequence {
    public static boolean isSubsequence(String s,String t){
        int n = s.length();
        int m = t.length();

        int i=0,j=0;

        while(i<n && j<m){
            if(s.charAt(i) == t.charAt(j)){
                i++;j++;
            }else{
                j++;
            }
        }
        if(i==n){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isSubsequence(s,t));
        sc.close();
    }
}
