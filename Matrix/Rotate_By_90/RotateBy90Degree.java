import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class RotateBy90Degree {
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        if(n == 0 || n == 1){
            return;
        }
        int i = 0;
        while(i<n){
            int r = 0;
            int c = n-1;
            while(r<=n-1-i){
                int temp = matrix[r][i];
                matrix[r][i] = matrix[n-1-i][n-1-r];
                matrix[n-1-i][n-1-r] = temp;
                r++;
            }
            i++;
        }
        System.out.println("Matrix after Swapping "+ Arrays.deepToString(matrix));
        flipMatrixHorizontal(matrix);
        System.out.println("Matrix after Rotate By 90 "+Arrays.deepToString(matrix));
    }

    public static void flipMatrixHorizontal(int[][] matrix){
        int n = matrix.length;
        for(int c=0;c<n;c++){
            int start = 0,end = n-1;
            while(start<end){
                int temp = matrix[start][c];
                matrix[start++][c] = matrix[end][c];
                matrix[end--][c] = temp;
            }
        }
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
        rotate(matrix);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
