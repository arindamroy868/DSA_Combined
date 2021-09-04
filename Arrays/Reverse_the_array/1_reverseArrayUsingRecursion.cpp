#include <iostream>
using namespace std;

// DSA450 Array Ques 1 : Reverse Array using Recursion
void reverseArray(int a[], int start, int end){
    if (start >= end)
        return;
    swap(a[start], a[end]);
    reverseArray(a, start+1, end-1);
}

int main(){
    int a[] = {1,2,3,4,5};
    int n = sizeof(a)/sizeof(int);

    // Print array
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout << endl;
    
    reverseArray(a, 0, n-1);

    // Print array
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";

    cout << endl;

    return 0;
}