import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class MaxRectangleInMatrix {
    public static int calArea(ArrayDeque<Integer> stack,int i,int top,int[] hist){
        if(stack.isEmpty()){
            return hist[top] * i;
        }else{
            return hist[top]*(i-stack.peek() - 1);
        }
    }

    public static int maxHistogram(int[] hist){
        int n = hist.length;
        if(n == 0){
            return 0;
        }
        int maxArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while(i<n){
            if(stack.isEmpty()){
                stack.push(i);
                i++;
            }else{
                if(!stack.isEmpty() && hist[stack.peek()]<=hist[i]){
                    stack.push(i);
                    i++;
                }else{
                    while(!stack.isEmpty() && hist[stack.peek()]>hist[i]){
                        int top = stack.pop();
                        int area = calArea(stack,i,top,hist);
                        maxArea = Math.max(area,maxArea);
                    }
                }
            }

        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            int area = calArea(stack,i,top,hist);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static void modifyMatrix(int[][] matrix){
        int n = matrix.length;
        if(n == 0){
            return;
        }
        int m = matrix[0].length;
        for(int r=1;r<n;r++){
            for(int c=0;c<m;c++){
                if(matrix[r][c] == 1){
                    matrix[r][c] = matrix[r-1][c] + 1;
                }
            }
        }
    }
    public static int maxRectangleInMatrix(int[][] matrix){
        int n = matrix.length;
        if(n==0){
            return 0;
        }
        int m = matrix[0].length;
        modifyMatrix(matrix);
        int maxRectangle = 0;
        for(int r=0;r<n;r++){
            maxRectangle = Math.max(maxRectangle,maxHistogram(matrix[r]));
        }
        return maxRectangle;
    }

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please row and column of matrix");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            if (n > 0) {
                System.out.println("Please enter elements of matrix");
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    for(int j=0;j<m;j++){
                        matrix[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
            System.out.println(maxRectangleInMatrix(matrix));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//M[][] = {{0 1 1 0},
//         {1 1 1 1},
//         {1 1 1 1},
//         {1 1 0 0}}
//4 4
//0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0

//4 3
//1 1 1
//1 0 1
//0 0 0
//1 1 0