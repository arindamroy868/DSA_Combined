import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class ParenthesisChecker {
    public static boolean ispar(String x){
        if(x.length() == 0)return true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] charArr = x.toCharArray();
        for(char c:charArr){
            if(c == '{' || c == '(' || c=='['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(top != '('){
                    return false;
                }
            }
            else if(c == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(top != '{'){
                    return false;
                }
            }
            else if(c == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(top != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            System.out.println(ispar(x));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
