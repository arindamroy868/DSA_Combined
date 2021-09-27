import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class Flood_Fill {
    public static void printPath(int[][] arr,int r,int c,String path){
        int n = arr.length;
        int m = arr[0].length;
        if(r<0 || r>=n || c<0 || c>=m || arr[r][c] ==1){
            return;
        }
        else if(r == n-1 && c == m-1){
            System.out.println(path);
            return;
        }
        //Mark Current Cell Visited
        arr[r][c] = 1;
        //Go to Upper Cell
        printPath(arr,r-1,c,path+"t");
        //Go to Left Cell
        printPath(arr,r,c-1,path+"l");
        //Go to Down Cell
        printPath(arr,r+1,c,path+"d");
        //Go to Right Cell
        printPath(arr,r ,c+1,path+"r");
        //Mark Current Cell Unvisited
        arr[r][c] = 0;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter row length");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println("Please enter column length");
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            if (n > 0 && m>0) {
                System.out.println("Please enter elements of Matrix");
                st = new StringTokenizer(br.readLine());
                Random rand = new Random();
                for (int i = 0; i < n; i++) {
                    for(int j =0; j<m ;j++){
                        arr[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                arr[n-1][m-1] = 0;
            }
            System.out.println("Matrix : "+Arrays.deepToString(arr));
            printPath(arr,0,0,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//0 0 0 0 1 0 1 0 0 0 0 0 0 1 0 1 1 1 0 0 1 1 0 0 0