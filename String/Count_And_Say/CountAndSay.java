import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CountAndSay {
    public static String countAndSay(int n){
        if(n==1){
            return "1";
        }
        String s = "1";
        while(n>1) {
            int count = 1;
            char prev = s.charAt(0);
            int i = 1;
            StringBuilder sb = new StringBuilder();
            while(i < s.length()){
                if(s.charAt(i) == prev){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(prev);
                    count = 1;
                    prev = s.charAt(i);
                }
                i++;
            }
            sb.append(count);
            sb.append(prev);
            s = sb.toString();
            n--;
        }
        return s;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter N");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(countAndSay(n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
