#include<bits/stdc++.h>
using namespace std;
// Count the no. of set bits in a given no.

// TC - O(logn)
int countBits(int n){
    int count = 0;
    while (n > 0){
        int lastBit = n & 1;
        count += lastBit; 
        n = n >> 1;
    }
    return count;
}

// Fast CountBit method - Faster than previous method
int FastCountBit(int n){
    int count = 0;
    while (n > 0){
        n = n & (n-1);
        count++;
    }
    return count;
}

int main(){
    int n = 7;
    // cout << countBits(n);
    cout << FastCountBit(n);

    cout << endl;
    return 0;
}