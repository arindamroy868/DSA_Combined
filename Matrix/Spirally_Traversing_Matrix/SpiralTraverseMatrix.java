import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpiralTraverseMatrix {
    public static String traverseMatrix(int[][] arr){
        if(arr.length == 0){
            return "";
        }
        int n = arr.length;
        int m = arr[0].length;

        int i=0,j=0;

        StringBuilder sb = new StringBuilder();
        while(i<n && j<m){
            int c = j,r=i;

            //Traversing Left to Right
            while(c<m){
                sb.append(arr[r][c++]+" ");
            }
            c--;r++;

            //Traversing Top to Bottom
            while(r<n){
                sb.append(arr[r++][c]+" ");
            }
            r--;c--;

            //Traversing Right to Left
            //If first row and last row are same no need to traverse again
            if(i != n-1){
                while(c>=j){
                    sb.append(arr[r][c--]+" ");
                }
                c++;r--;
            }

            //Traversing Bottom to Top
            if(j != m-1){
                while(r>i){
                    sb.append(arr[r--][c]+" ");
                }
            }


            i++;//Starting from next row
            j++;//Starting from next column
            n--;//Last max row -1
            m--;//Last max col -1

        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter row and column");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j] = ++count;
                }
            }
            System.out.println("Original Array\n"+ Arrays.deepToString(arr));
            System.out.println(traverseMatrix(arr));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
