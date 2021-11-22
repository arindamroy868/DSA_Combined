package Count_Pairs_With_Given_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class countPairsSum {
    public static void getPairsCount(int arr[], int n, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<n;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],0);
            }
            hm.put(arr[i],hm.get(arr[i]+1));
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(hm.get(k-arr[i])!=null){
                count = count+hm.get(k-arr[i]);
                if (k - arr[i] == arr[i]) {
                    count--;
                }
            }

        }
        System.out.println(count/2);
    }
    public static void main(String[] args) {
        int[] a = new int[10];
        int n,i=0,k;
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Number of inputs");
        n = sc.nextInt();
        System.out.println("Sum");
        k = sc.nextInt();
        for(i=0;i<n;i++)
            a[i] = sc.nextInt();
        getPairsCount(a,n,k);
    }
}

