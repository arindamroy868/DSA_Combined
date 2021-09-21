import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class All_Possible_Subsequences {
    static List<String> powerSet = new ArrayList<>();
    public static void allPossibleSubsequences(String s,String res){
        if(s.length() == 0){
            powerSet.add(res);
        }
        else{
            allPossibleSubsequences(s.substring(1),res+s.charAt(0));
            allPossibleSubsequences(s.substring(1),res);
        }

    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter string");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            allPossibleSubsequences(s,"");
            System.out.println(powerSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
