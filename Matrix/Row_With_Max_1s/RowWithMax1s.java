import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class RowWithMax1s {
    public static int rowWithMax1s(int[][] arr,int n,int m){
        if(n==0 && m == 0){
            return -1;
        }
        int r = 0, c = m-1;

        int index = -1;
        while(r<n && c>=0){
            if(arr[r][c] == 1){
                index = r;
                c--;
            }else{
                r++;
            }
        }
        return index;
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter row and col of Matrix");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            if (n > 0 && m>0) {
                System.out.println("Please enter elements of Matrix");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    for(int j = 0;j<m;j++){
                        matrix[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println(rowWithMax1s(matrix,n,m));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//3 9
//0 0 0 1 1 1 1 1 1 0 0 0 0 1 1 1 1 1 0 0 0 0 1 1 1 1 1
