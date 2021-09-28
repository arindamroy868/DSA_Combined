import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class NQueens {
    public static boolean cellIsSafe(int[][] chess,int row,int col){
        //Check in the same column
        for(int r=0;r<row;r++){
            if(chess[r][col] == 1){
                return false;
            }
        }

        //Check Left Diagonal
        for(int r=row,c=col;r>=0 && c>=0;r--,c--){
            if(chess[r][c] == 1){
                return false;
            }
        }

        //Check Right Diagonal
        for(int r=row,c=col;r>=0 && c<chess.length;r--,c++){
            if(chess[r][c] == 1){
                return false;
            }
        }
        return true;
    }
    public static void printNQueens(int[][] chess,String qsf,int row){
        if(row == chess.length){
            System.out.println(qsf+".");
            return;
        }
        for(int col=0;col<chess.length;col++){
            if(cellIsSafe(chess,row,col)){
                chess[row][col] = 1;
                printNQueens(chess,qsf+row+"-"+col+", ",row+1);
                chess[row][col] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter size of Matrix");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][n];
            printNQueens(matrix,"",0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
