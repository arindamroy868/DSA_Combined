import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class CheckStringIsShuffle {
    //Time = O(N)
    //Space = O(N)
    public static boolean checkStringShuffle(String s1,String s2,String result){
        if(result.length() != s1.length() + s2.length()){
            return false;
        }
        boolean isShuffle = true;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(char c:result.toCharArray()){
            if(map1.containsKey(c)){
                map1.put(c,map1.get(c)+1);
            }else{
                map1.put(c,1);
            }
        }

        for(char c:s1.toCharArray()){
            if(map2.containsKey(c)){
                map2.put(c,map2.get(c)+1);
            }else{
                map2.put(c,1);
            }
        }
        for(char c:s2.toCharArray()){
            if(map2.containsKey(c)){
                map2.put(c,map2.get(c)+1);
            }else{
                map2.put(c,1);
            }
        }

        for(Map.Entry<Character,Integer> entry:map1.entrySet()){
            if(!map2.containsKey(entry.getKey()) || (map2.get(entry.getKey()) != entry.getValue())){
                isShuffle = false;
                break;
            }
        }
        return isShuffle;
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

            System.out.println("Please enter String 3");
            st = new StringTokenizer(br.readLine());
            String s3 = st.nextToken();
            System.out.println(checkStringShuffle(s1,s2,s3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
