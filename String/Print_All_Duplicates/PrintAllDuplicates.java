import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class PrintAllDuplicates {
    public static void printDuplicates(String s){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }else{
                hm.put(s.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            if(entry.getValue()>1){
                System.out.println(entry.getKey()+" -> "+entry.getValue());
            }
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter string");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            printDuplicates(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
