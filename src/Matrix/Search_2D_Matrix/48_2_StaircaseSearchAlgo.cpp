#include <iostream>
using namespace std;

// Seaching an element in sorted 2D array(sorted in both rowwise and columnwise) using Staircase Search Algorithm which take O(n+m) time
pair<int, int> stairCaseSearch(int arr[][4], int n, int m, int key){
    //If element is smaller than smallest element or larger than lasgest element than it's not present than return {-1,-1}
    if (key < arr[0][0] || key > arr[n-1][m-1])
        return {-1,-1};

    // Staircase Search
    int i = 0;  // ith iterator to traverse row wise
    int j = m-1;    // jth for column wise
    while (i<n && j>=0){
        if (key == arr[i][j])
            return {i,j};

        else if (key > arr[i][j])
            i++;
        
        else
            j--;
    }
    return {-1, -1};
}

int main(){
    int arr[][4] = {
        {10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}
    };

    int n=4, m=4;
    int key = 39;

    pair<int, int> coord =  stairCaseSearch(arr, n, m, key);
    cout << coord.first << "," << coord.second << endl;

    return 0;
}