import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class SplitBinaryString {
    public static int splitBinaryString(String s){
        if(s.length() == 0)return 0;
        int counter = 0;
        int res = 0;
        char[] string = s.toCharArray();
        for(char c:string){
            if(c == '0'){
                counter++;
            }else{
                counter--;
            }
            if(counter == 0){
                res++;
            }
        }
        return counter == 0?res:-1;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter String");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            System.out.println(splitBinaryString(s));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
