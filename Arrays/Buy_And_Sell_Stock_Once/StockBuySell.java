package com.dsa.arrays;

import java.util.Scanner;

public class StockBuySell {
    public static int bestStrat(int a[],int n){
        if(n==1){
            return 0;
        }
        int min = a[0], maxDiff = 0, max = a[1];
        for(int i =1;i<n;i++){
            if(min>a[i]){
                min = a[i];
                max = a[i];
            }
            else if(max<a[i]){
                max = a[i];
            }
            if(maxDiff<(max-min)) {
                maxDiff = max - min;
            }
        }
        if(maxDiff<0){
            return 0;
        }
        else
            return maxDiff;
    }
    public static void main(String[] args) {
        int[] a = new int[10];
        int n,i=0;
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Number of inputs");
        n = sc.nextInt();
        for(i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(bestStrat(a,n));
    }
}
