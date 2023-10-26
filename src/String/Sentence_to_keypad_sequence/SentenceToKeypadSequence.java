import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class SentenceToKeypadSequence {
    public static void setenceToKeypadSequence(String s){
        if(s.isEmpty())return;
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[]{"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777","8","88","888","9","99","999","9999"};

        System.out.println("Keypad : "+Arrays.toString(arr));
        for(char c:s.toCharArray()){
            if(c == ' '){
                sb.append("0");
            }else{
                sb.append(arr[c-65]);
            }
        }
        System.out.println("Result :"+sb);
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter Sentence");
            String sentence = br.readLine();
            setenceToKeypadSequence(sentence);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
