import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class PrintAllPermutationOfString {
    public static void findPermutationHelper(String S,String ans,List<String> res){
        if(S.length() == 0){
            res.add(ans);
            return;
        }
        for(int i=0;i<S.length();i++){
            findPermutationHelper(S.substring(0,i)+S.substring(i+1),ans+S.charAt(i),res);
        }
    }
    public static List<String> find_permutation(String S){
        List<String> res = new ArrayList<>();
        findPermutationHelper(S,"",res);
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter String");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            System.out.println(find_permutation(S));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
