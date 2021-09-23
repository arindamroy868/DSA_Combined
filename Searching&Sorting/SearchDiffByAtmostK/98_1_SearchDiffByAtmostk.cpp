#include<bits/stdc++.h>
using namespace std;
// DSA450 98: Searching in an array where adjacent differ by at most k

// Bruteforce Approach : Directly using Linear Search. TC- O(n), SC - O(1)

// Optimised Approach TC-O(n), SC-O(1), i.e., Less no. of search(jump)
int searchX(vector<int> arr, int x, int k){
    int i=0;
    while (i<arr.size()){
        if(arr[i] == x)
            return i;
        i = i + max(1, abs(arr[i]-x)/k);
    }
    return -1;
}

int main(){
    vector<int> arr = {5,6,7,9,11,10};
    int k = 2;  // Atmost K difference btw each element of an array
    int x = 11; // Given element to search
    cout << x <<" found at index " << searchX(arr, x, k);

    cout << endl;
    return 0;
}