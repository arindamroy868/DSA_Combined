import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CheckRotationInSubstring {
    //Naive Approach
    public static boolean checkRotation(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        s1 = s1+s1;
        boolean found = false;
        int i=0,j=s2.length();
        while(j<=s1.length()){
            if(s1.substring(i,j).equals(s2)){
                found = true;
                break;
            }
            i++;
            j++;
        }
        return found;
    }

    //Using KMP String-Matching Algorithm
    public static boolean checkRotation2(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        boolean found = false;
        int[] lps  = generateLps(s2);
        s1 = s1.concat(s1);
        int i = 0,j=0;
        while(i<s1.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;j++;
            }
            if(j == s2.length()-1){
                found = true;
                System.out.println("Match Found at i = "+i+" & j = "+(i+j));
                break;
            }
            else if(i<s1.length() && s1.charAt(i) != s2.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return found;
    }

    public static int[] generateLps(String s){
        if(s.length() == 0){
            return new int[0];
        }
        int[] lps = new int[s.length()];

        int i = 0,j=1;
        while(j<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                ++i;
                lps[j] = i;
                j++;
            }else if(i==0){
                j++;
            }else{
                i = lps[i-1];
            }
        }
        return lps;
    }


    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter String 1");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();

            System.out.println("Please enter String 2");
            st = new StringTokenizer(br.readLine());
            String s2 = st.nextToken();
            System.out.println(checkRotation(s1,s2));
            System.out.println(Arrays.toString(generateLps(s2)));
            System.out.println(checkRotation2(s1,s2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
