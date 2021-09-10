import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        int n;
        System.out.println("Please enter the length of permutation");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Please enter the digits from left");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        nextPermutaion(a);
        System.out.println(Arrays.toString(a));
    }

    public static void nextPermutaion(int[] a){
        int i = a.length - 1;
        //Finding Breakpoint 13542  break point is between 3 & 5 ->  1 3 | 5 4 2
        //                                                                 i
        while(i>0){
            if(a[i]>a[i-1]){
                break;
            }
            i--;
        }

        if(i!=0){
            //Finding the swap for (i-1)  1 3 | 5 4 2
            //                             i-1    j
            int j;
            for(j = a.length-1;j>=i;j--){
                if(a[j]>a[i-1]){
                    break;
                }
            }
            //Swapping a[i-1] with a[j]
            int temp = a[i-1];
            a[i-1] = a[j];
            a[j] = temp;
        }




        //Reversing subArray a[i:n]
        int j = a.length-1;
        while(i<j) {
            int temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
}
