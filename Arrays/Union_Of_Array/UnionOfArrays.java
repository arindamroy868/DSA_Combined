package Union_Of_Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class UnionOfArrays {
    //Time=O(N+M)
    //Space=O(N+M)
    public static int unionOfArrays(Integer[] a,Integer[] b){
        HashSet<Integer> hs = new HashSet<>();
        for(Integer x:a){
            hs.add(x);
        }
        for(Integer x:b){
            hs.add(x);
        }
        List<Integer> res = hs.stream().collect(Collectors.toList());
        System.out.println("Union Array : "+res);
        return hs.size();
    }
    //Time=O(N+M)
    //Space=O(Min(N,M));
    public static int intersectionOfArrays(Integer[] a,Integer[] b){
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        if(a.length<b.length){
            Integer[] temp = a;
            a = b;
            b = temp;
        }
        for(Integer x:b){
            hs.add(x);
        }

        for(Integer x: a){
            if(hs.contains(x)){
                res.add(x);
            }
        }
        System.out.println("Intersection of Arrays : "+res);
        return res.size();
    }
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("Please enter size of array 1");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer[] a = new Integer[n];
            if(n>0){
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Please enter size of array 2");
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            Integer[] b = new Integer[m];
            if(m>0){
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < m; i++) {
                    b[i] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Before Operation -> "+Arrays.deepToString(a)+"\n"+Arrays.deepToString(b));
            System.out.println("Union Length : "+unionOfArrays(a,b));
            System.out.println("Intersection Length : "+intersectionOfArrays(a,b));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
