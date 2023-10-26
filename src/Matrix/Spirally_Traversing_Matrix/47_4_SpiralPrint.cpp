#include <iostream>
using namespace std;

void spiralPrint(int arr[][4], int n, int m){
    // variables
    int startRow = 0;
    int endRow = n-1;
    int startCol = 0;
    int endCol = m-1;

    // Outer Loop to traverse the boundary
    while (startRow <= endRow && startCol <= endCol){
        // startRow
        for (int col = startCol; col <= endCol; col++){
            cout << arr[startRow][col] << " ";
        }

        // endCol
        for (int row = startRow+1; row <= endRow; row++){
            cout << arr[row][endCol] << " ";
        }

        // endRow
        for (int col = endCol-1; col >= startCol; col--){
            if (startRow == endRow)     // When it traverse back row wise
                break;
            
            cout << arr[endRow][col] << " ";
        }

        // startCol
        for (int row = endRow-1; row >= startRow+1; row--){
            if (startCol == endCol)     // When it traverse back col wise
                break;
            
            cout << arr[row][startCol] << " ";
        }

        // Variable changes
        startRow++;
        endCol--;
        endRow--;
        startCol++;
    }  
}

int main(){
    int arr[][4] = {
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}
    };

    int n, m;
    cin >> n >> m;

    spiralPrint(arr, n, m);

    return 0;
}