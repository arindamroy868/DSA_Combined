#include<bits/stdc++.h>
using namespace std;
// DSA450 96: Find the repeating & Missing Element in an Array

// BruteForce Approach - to take extra count array which will record each element freq if 0 than missing if > 1 than repeat
int *findTwoElement1(int *arr, int n){
    int rep, mis;
    // Creating dynamic freq array
    int *freq = new int[n+1];
    // Initializing freq array
    for (int i = 0; i < n+1; i++)
        freq[i] = 0;
    
    for (int i = 0; i < n; i++){
        if(arr[i] > 0 && arr[i] <= n)
            freq[arr[i]]++;
    }

    // Getting repeating & missing element
    for (int i = 0; i < n+1; i++){
        if(freq[i] > 1)
            rep = i;
        if(freq[i] == 0)
            mis = i;
    }
    
    int *result = new int[2];
    result[0] = rep;
    result[1] = mis;

    return result;
    
}


// Optimized Approach - First we'll find the repeating element by initially marking the visited element as -ve & repeated will be the one which we encounter
// again as -ve (its index) & also traverse till last element and then the one who is +ve its index will be our missing element TC- O(n), SC- O(1)
int *findTwoElement(int *arr, int n) {
    int rep, mis;

    // For repeated element
    for (int i = 0; i < n; i++){
        // Checking if element already visited or not & -1 becoz of 0 based indexing
        if (arr[abs(arr[i])-1] < 0)
            rep = abs(arr[i]);
        else
            arr[abs(arr[i])-1] = -arr[abs(arr[i])-1];   // Marking the visited element as -ve 
    }

    // For Missing Element
    for (int i = 0; i < n; i++){
        if (arr[i] > 0){
            mis = i+1;
            break;
        }
    }
    
    // creating dynamic array to return the result
    int *result = new int[2];
    result[0] = rep;
    result[1] = mis;

    return result;
}

int main(){
    int arr[] = {2,5,2,1,4};
    int n = sizeof(arr)/sizeof(arr[0]);

    //int *ptr = findTwoElement(arr, n);
    int *ptr = findTwoElement1(arr, n);

    cout << "Repeated Element = " << ptr[0] << ", " << "Missing Element = " << ptr[1];

    cout << endl;
    return 0;
}