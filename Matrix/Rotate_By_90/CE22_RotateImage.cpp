#include<bits/stdc++.h>
using namespace std;

// Coding Exercise 22 : Rotate Image 
// Logic : First Transpose the matrix(row <=> column) and than reverse each row vector elements for rotating image 90 clockwise
// For Anti-clockwise reverse each column vector elements 
void rotate(vector<vector<int>>& matrix) {
    //For Anti-clockwise Rotation : First Reverse each row elements than transpose
    for (int i = 0; i < matrix.size(); i++){
        reverse(matrix[i].begin(), matrix[i].end());
    }

    // Transpose of the matrix : swapping each row elements with column elements
    for (int i = 0; i < matrix.size(); i++){
        for (int j = 0; j < i; j++){
            swap(matrix[i][j], matrix[j][i]);
        }
    }
    
    //For Clockwise Rotation : Reversing each row elements after transposing
    // for (int i = 0; i < matrix.size(); i++){
    //     reverse(matrix[i].begin(), matrix[i].end());
    // }
}

int main(){
    vector<vector<int>> matrix = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };

    cout << "Original Matrix \n";
    for (vector<int> matrix1D : matrix){
        for (int x: matrix1D){
            cout << x << " ";
        }
        cout << endl;
    }

    rotate(matrix);

    cout << "After Rotation \n";
    for (vector<int> matrix1D : matrix){
        for (int x: matrix1D){
            cout << x << " ";
        }
        cout << endl;
    }
     

    return 0;
}