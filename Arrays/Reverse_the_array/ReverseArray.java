package com.dsa.arrays;
import java.util.Scanner;

public class ReverseArray {
    static void RevArray(int a[],int n){
        for(int i = 0;i<n/2;i++){
            a[i] = a[i]+a[n-1-i];
            a[n-1-i] = a[i]-a[n-1-i];
            a[i] = a[i]- a[n-1-i];
        }
    }
    static void RevArray(int a[],int n, int i){
        if(i>=n/2){
            return;
        }
        a[i] = a[i]+a[n-1-i];
        a[n-1-i] = a[i]-a[n-1-i];
        a[i] = a[i]- a[n-1-i];
        RevArray(a,n,i+1);

    }


    public static void main(String[] args) {
	// write your code here
        int[] a = new int[10];
        int n,i=0;
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Number of inputs");
        n = sc.nextInt();
        for(i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        RevArray(a,n); //normal approach
        for(i=0;i<n;i++){
            System.out.print(a[i]);
        }
        System.out.println();
        i = 0;
        RevArray(a,n,i); //recursion
        for(i=0;i<n;i++){
            System.out.print(a[i]);
        }
    }
}
