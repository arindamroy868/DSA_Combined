import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

//Time = O(log(n*m))
//Space = O(1)
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix,int target){
        if(matrix.length == 0){
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;
        boolean found = false;
        while(low<=high){
            int mid = (low+high)/2;
            int r = mid/m;
            int c = mid%m;
            if(matrix[r][c] == target){
                found = true;
                break;
            }else if(matrix[r][c] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return found;

    }

    public static void main(String[] args) throws Exception {
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
            System.out.println("Please enter target number");
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            System.out.println(searchMatrix(arr,target));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
