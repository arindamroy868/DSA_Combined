package Bar_Chart_Printing;

import java.util.Scanner;

public class BarChartPrint {
     public static void main(String[] args) throws Exception {
            // write your code here
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max = -1;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                max = Math.max(max,arr[i]);
            }

            while(max>0){
                for(int j=0;j<n;j++){
                    if(arr[j]>=max){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }
                max--;
                System.out.println();
            }
        sc.close();
     }
}
