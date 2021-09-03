package com.dsa.arrays;

import java.util.Scanner;

public class sort012 {
    public static void sort(int a[],int n){
        int x=0,z=n-1;
        for(int i = 0;i<=z;i++){

            if(a[i]==0){
                if(i==x){
                    x++;
                }
                else {
                    a[i] = a[i] + a[x];
                    a[x] = a[i] - a[x];
                    a[i] = a[i] - a[x];
                    x++;
                    i--;
                }
            }
            else if(a[i]==2){
                if (a[i] != a[z]) {
                    a[i] = a[i] + a[z];
                    a[z] = a[i] - a[z];
                    a[i] = a[i] - a[z];
                }
                z--;
                i--;
            }
        }
        for(int i = 0; i<n; i++) {
            System.out.print(a[i]);
        }
    }
    public static void main(String[] args) {
        int[] a = new int[20];
        int n,i=0;
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Number of inputs");
        n = sc.nextInt();
        for(i=0;i<n;i++)
            a[i] = sc.nextInt();
        sort(a,n);
    }
}
