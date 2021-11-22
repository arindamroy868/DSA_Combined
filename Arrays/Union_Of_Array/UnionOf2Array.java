package Union_Of_Array;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class UnionOf2Array {
    static void unionCount(int a[], int b[],int n, int m) {
        Map<Integer,Integer> mp = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++) {
            mp.put(a[i], i);
        }
        for(int i = 0; i < m; i++) {
            mp.put(b[i], i);
        }
        System.out.println(mp.size());


    }

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10];
        int n,m,i=0;
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Number of inputs");
        n = sc.nextInt();
        m = sc.nextInt();
        for(i=0;i<n;i++)
            a[i] = sc.nextInt();
        for(i=0;i<m;i++)
            b[i] = sc.nextInt();
        unionCount(a,b,n,m);
    }
}
