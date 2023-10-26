package Common_Elements_In_3_Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class CommonElementsIn3Arrays {
    //Optimal for Not Sorted Arrays
    //Time=O(N1+N2+N3)
    //Space=O(N1+N2+N3)
    public static List<Integer> commonElements(int[] A,int[] B,int[] C,int n1,int n2,int n3){
        if(n1 == 0 || n2 == 0 ||n3 == 0){
            return new ArrayList<>();
        }
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int x:A){
            hs1.add(x);
        }
        for(int y:B){
            if(hs1.contains(y)){
                hs2.add(y);
            }
        }
        for(int z:C){
            if(hs2.contains(z)){
                res.add(z);
            }
        }
        return res.stream().sorted().collect(Collectors.toList());
    }

    //Optimal for Sorted Arrays
    //Time=O(N1+N2+N3)
    //Space=O(1)
    public static List<Integer> commonElements2(int[] A,int[] B,int[] C,int n1,int n2,int n3) {
        if(n1==0 || n2==0 ||n3==0){
            return new ArrayList<>();
        }
        int i=0,j=0,k=0;
        ArrayList<Integer> res = new ArrayList<>();
        int prev = Integer.MIN_VALUE;

        while(i<n1 && j<n2 && k<n3){
            if(A[i] == B[j] && B[j] == C[k]){
                if(prev != A[i]){
                    res.add(A[i]);
                    prev = A[i];
                }
                i++;j++;k++;
            }else if(A[i]<B[j]){
                i++;
            }else if(B[j]<C[k]){
                j++;
            }else{
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter length of 3 arrays");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            int[] A = new int[n1];
            int[] B = new int[n2];
            int[] C = new int[n3];

            if (n1 > 0) {
                System.out.println("Please enter elements of array1");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n1; i++) {
                    A[i] = Integer.parseInt(st.nextToken());
                }
            }
            if (n2 > 0) {
                System.out.println("Please enter elements of array2");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n2; i++) {
                    B[i] = Integer.parseInt(st.nextToken());
                }
            }
            if (n3 > 0) {
                System.out.println("Please enter elements of array3");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n3; i++) {
                    C[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(commonElements(A,B,C,n1,n2,n3));
            System.out.println(commonElements2(A,B,C,n1,n2,n3));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
