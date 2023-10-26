import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class SortedMatrix {
    public static int[][] sortMatrix(int n,int[][] Mat){
        if(n>1){
            int[] array = new int[n*n];
            int k = 0;
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    array[k++] = Mat[r][c];
                }
            }
            Arrays.sort(array);
            k = 0;
            for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    Mat[r][c] = array[k++];
                }
            }
        }
        return Mat;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter row and col of Matrix");
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
            System.out.println(Arrays.deepToString(sortMatrix(n,matrix)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
