import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class RabinKarpALgo {
    public static void rabinKarpPatternMatching(String txt,String pat){
        //Total Ascii Characters
        int d = 256;
        //Length of text and pattern
        int n = txt.length();
        int m = pat.length();
        int i,j;
        //p will store the hash value of current window of text
        //t will store the hash value of the pattern
        int p = 0;
        int t = 0;
        //A prime number used to calculate the modulo of the hash,
        //in case of hash value goes beyond
        //the possible range of integer values
        int q = 139;
        //Helper variable to store the value of Pow(d,m-1)
        int h = 1;
        for(i=0;i<m;i++){
            h = (h*d)%q;
        }

        //Initially calculate the hash of pat and first window of txt
        for(i=0;i<m;i++){
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + txt.charAt(i))%q;
        }

        //Now check for each window if the hash of that matches with the pattern hash or not
        for(i=0;i<n-m;i++){
            //Check hash values of current window and pattern
            if(p == t){
                //Check for each character in the pattern and the txt
                for(j=0;j<m;j++){
                    if(pat.charAt(j) != txt.charAt(i+j)){
                        break;
                    }
                }
                if(j == m){
                    System.out.println("Match found at index : "+i);
                }
            }
            //Calculate hash for next window
            if(i<n-m){
                t = ((d*(t - txt.charAt(i)*h)) + txt.charAt(i+m))%q;
                if(t<0){
                    t = t+q;
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter text");
            StringTokenizer st = new StringTokenizer(br.readLine());
            String text = st.nextToken();
            System.out.println("Please enter pattern");
            st = new StringTokenizer(br.readLine());
            String pattern = st.nextToken();
            rabinKarpPatternMatching(text,pattern);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
