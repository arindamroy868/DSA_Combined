import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class RearrangeArrayAltPosNegElements {
    //Time=O(N)
    //Space=O(N)
    public static int[] rearrangeArray(int[] A){
        int n = A.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[n];

        //Find next -ve and +ve elements
        while(i<n && j<n){
            while(i<n && A[i]>=0){
                i++;
            }
            while(j<n && A[j]<0){
                j++;
            }
            if(i<n && j<n){
                res[k++] = A[i++];
                res[k++] = A[j++];
            }
        }

        while(i<n){
            if(A[i]<0){
                res[k++] = A[i];
            }
            i++;
        }

        while(j<n){
            if(A[j]>=0){
                res[k++] = A[j];
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of array");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            if (n > 0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(Arrays.toString(arr));
            int[] res = rearrangeArray(arr);
            System.out.println(Arrays.toString(res));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//-5 -2 5 2 4 7 1 8 0 -8
//1 2 3 -4 -1 4
//5 2 1 3 7 8 9 10
//-3 -1 -4 -5 10 -1