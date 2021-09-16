import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class FindSpecificPairMatrix {
    //Time=O(N2)
    //Space=O(N2)
    public static int findPair(int[][] matrix){
        int n = matrix.length;
        if(n<=1){
            return -1;
        }
        int[][] minMatrix = new int[n][n];

        //Creating Min Matrix - minMaxtrix[r][c] = Minimum value encountered in row r from column 0 to C;
        //eg: 1 2 -1 4
        //For this Row in Matrix - Row in minMatrix will be
        // 1 1 -1 -1
        for(int r=0;r<n;r++){
            int min = Integer.MAX_VALUE;
            for(int c=0;c<n;c++){
                minMatrix[r][c] = Math.min(min,matrix[r][c]);
                min = minMatrix[r][c];
            }
        }
        System.out.println("Min Matrix ->:"+Arrays.deepToString(minMatrix));

        //Creating Min Matrix - minMaxtrix[r][c] = Minimum value encountered in column C from row 0 to r;
        //eg:
        //  1
        //  2
        // -1
        // -2
        //For this Column in Matrix - Column in minMatrix  will be
        //  1
        //  1
        // -1
        //  -2
        for(int c=0;c<n;c++){
            int min = Integer.MAX_VALUE;
            for(int r=0;r<n;r++){
                minMatrix[r][c] = Math.min(min,minMatrix[r][c]);
                min = minMatrix[r][c];
            }
        }
        System.out.println("Min Matrix ->:"+Arrays.deepToString(minMatrix));

        //Traverse From Right Bottom to Top Left and Calculate Max Difference
        int difference = Integer.MIN_VALUE;
        for(int r=n-1;r>0;r--){
            for(int c=n-2;c>0;c--){
                difference = Math.max(difference,(matrix[r][c] - minMatrix[r-1][c-1] ));
            }
        }
        return difference;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter size of Square Matrix");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][n];
            if (n > 0) {
                System.out.println("Please enter elements of Matrix");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    for(int j = 0;j<n;j++){
                        matrix[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println("Matrix -> "+Arrays.deepToString(matrix));
            System.out.println(findPair(matrix));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//5
//1 2 -1 -4 -20 -8 -3 4 2 1 3 8 6 1 3 -4 -1 1 7 -6 0 -4 10 -5 1