import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MaximumSizeSquareWith1s {
    public static int maxSquare(int[][] matrix){
        int n = matrix.length;
        //To store max size
        int maxSquare = 0;

        if(n != 0){
            int m = matrix[0].length;

            //This is a dp problem
            //Dividing Bigger Problem in smaller chunks
            //For each cell in matrix : matrix[r][c]
            //we calculate the maximum size square we can make
            //with this cell as the bottom right element of square
            //For that purpose we create a separate matrix - dp

            //Creating a new matrix to store the result of each cell
            int[][] dp = new int[n][m];

            //For First row and First column store as it is
            //Because the max size square we can make with only
            //one cell is size = 1
            for(int i=0;i<m;i++){
                dp[0][i] = matrix[0][i];
            }

            for(int i=0;i<n;i++){
                dp[i][0] = matrix[i][0];
            }

            //For rest of cells
            for(int r=1;r<n;r++){
                for(int c=1;c<m;c++){
                    if(matrix[r][c] == 0){
                        dp[r][c] = 0;
                    }else{
                        dp[r][c] = Math.min(dp[r-1][c-1],Math.min(dp[r-1][c],dp[r][c-1]))+1;
                        maxSquare = Math.max(dp[r][c],maxSquare);
                    }
                }
            }
            return maxSquare;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter size of matrix NxM : N M");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            if (n > 0 && m>0) {
                System.out.println("Please enter elements of array");
                st = new StringTokenizer(br.readLine());
                for (int i=0; i<n; i++) {
                    for(int j=0 ; j<m ; j++){
                        matrix[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println(Arrays.deepToString(matrix));
            System.out.println(maxSquare(matrix));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
