package com.dsa.arrays;
import java.util.Scanner;
import java.util.Arrays;

public class RotateByOne {
    public static void rotate(int arr[],int n)
    {
        int x = arr[n-1];
        for (int i = n-1; i > 0; i--)
            arr[i] = arr[i-1];
        arr[0] = x;
    }

    public static void main(String[] args) {
        int[] a = new int[5];
        int n,i=0;
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Number of inputs");
        n = sc.nextInt();
        for(i=0;i<n;i++)
            a[i] = sc.nextInt();
        rotate(a,n);
        System.out.println(Arrays.toString(a));
    }
}
