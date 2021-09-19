import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class ReverseAString {
    public static String reverse(String s){
        if(s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter the string");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            s = reverse(s);
            System.out.println("After Reversing : "+s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
